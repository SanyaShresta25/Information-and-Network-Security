import re
from collections import Counter
import matplotlib.pyplot as plt
import os

# Path to Cowrie log file
log_file = "/home/cowrie8/cowrie/var/log/cowrie/cowrie.log"

# Ensure graphs folder exists
output_folder = "graphs"
os.makedirs(output_folder, exist_ok=True)

# Pattern to extract IP, username, and password
pattern = re.compile(
    r"\[HoneyPotSSHTransport,\d+,([\d.]+)\] login attempt \[b'([^']+)'/b'([^']+)'\]"
)

# Counters
usernames = Counter()
passwords = Counter()
ip_addresses = Counter()
total_attempts = 0

# Read and parse the log file
try:
    with open(log_file, "r") as file:
        for line in file:
            match = pattern.search(line)
            if match:
                ip, username, password = match.groups()
                usernames[username] += 1
                passwords[password] += 1
                ip_addresses[ip] += 1
                total_attempts += 1
except FileNotFoundError:
    print(f"Log file not found: {log_file}")
    exit()

# Print statistics
print(f"Total login attempts: {total_attempts}")
print(f"Top 5 Usernames: {usernames.most_common(5)}")
print(f"Top 5 Passwords: {passwords.most_common(5)}")
print(f"Top 5 IP Addresses: {ip_addresses.most_common(5)}")

# Function to plot and save graph
def plot_counter(counter, title, xlabel, filename):
    items = counter.most_common(5)
    if not items:
        print(f"No data to plot for {title}.")
        return
    labels, values = zip(*items)

    plt.figure(figsize=(10, 6))
    plt.bar(labels, values, color='skyblue')
    plt.title(title)
    plt.xlabel(xlabel)
    plt.ylabel("Count")
    plt.xticks(rotation=45)
    plt.tight_layout()
    save_path = os.path.join(output_folder, filename)
    plt.savefig(save_path)
    plt.close()
    print(f"Graph saved: {save_path}")

# Create graphs
plot_counter(usernames, "Top Usernames Attempted", "Username", "usernames.png")
plot_counter(passwords, "Top Passwords Attempted", "Password", "passwords.png")
plot_counter(ip_addresses, "Top IP Addresses", "IP Address", "ip_addresses.png")
