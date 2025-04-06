# Honeypot Setup and Monitoring using Cowrie

## **Objective**

This project aims to set up and configure the Cowrie honeypot on an Ubuntu VM to monitor network activity and detect potential threats. Cowrie simulates SSH and Telnet services to capture attacker activity such as login attempts, commands, and malware uploads.

---

## **Prerequisites**

- **Oracle VM VirtualBox**: Virtualization software for running the Ubuntu VM.
- **Ubuntu 22.04 LTS**: Operating system installed inside the VM.
- **Internet Access**: For downloading necessary dependencies and updating the system.
- **SSH/Telnet Simulation**: Cowrie will simulate SSH and Telnet services to capture network activity.

---

## 🎥 Project Demo: Honeypot Setup & Monitoring

[![Watch the Demo](https://img.youtube.com/vi/qQXicKc5wQM/0.jpg)](https://youtu.be/qQXicKc5wQM)

> 🚀 Click the image above to watch the full walkthrough of setting up Cowrie Honeypot, capturing logs, and visualizing attacks in action!


## **Setup Instructions**

### 1. **System Update**

Ensure that your system is up-to-date.

### 2. **Install Dependencies**

Install the required dependencies such as Git, Python, and other necessary libraries.

### 3. **Create a Dedicated User for Cowrie**

Create a new user to run Cowrie and switch to that user.

### 4. **Clone Cowrie Repository**

Clone the Cowrie repository from GitHub and navigate to the project directory.

### 5. **Set Up Python Virtual Environment**

Create and activate a Python virtual environment to isolate dependencies for Cowrie.

### 6. **Install Python Requirements**

Install all the Python packages necessary for Cowrie to run correctly.

### 7. **Configure Cowrie**

Copy the sample configuration file to the active configuration file and modify it according to your needs.

### 8. **Start Cowrie**

Start the Cowrie honeypot to begin monitoring network activity.

### 9. **Check Cowrie Status and Logs**

Check the logs and status of Cowrie to ensure it's working correctly.

### 10. **Test SSH Honeypot**

Test the SSH honeypot by trying to connect to it using an SSH client.

### 11. **Stop Cowrie**

Stop the Cowrie honeypot when you're done with the monitoring.

---

## **Features**

### 1. **🚨 Automated Fake Attacker Script**

This script simulates fake brute-force attacks on your Cowrie honeypot. It repeatedly tries different username and password combinations on the SSH service, mimicking real attack scenarios.

### 2. **📊 Log Analyzer Script**

The log analyzer script summarizes Cowrie logs, providing key statistics such as:

- Total login attempts 🔢
- Unique usernames 👤
- Unique passwords 🔑
- IP addresses of attackers 🌍

### 3. **📈 Log Visualization with Python**

This feature visualizes log analysis results with graphs using Python's Matplotlib library. The graphs include:

- Top 5 usernames attempted 👥
- Top 5 passwords attempted 🔒
- Top 5 IP addresses of attackers 🌐

Graphs are saved and can be used for deeper analysis of attack patterns.

---

## **Conclusion**

By setting up Cowrie, you can monitor unauthorized access attempts and gather valuable insights into potential attacker behavior. The additional scripts for fake attacks and log analysis enhance the monitoring capabilities, making this setup effective for threat detection and research purposes.

