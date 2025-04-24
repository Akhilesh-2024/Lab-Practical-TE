def information_management():
    print("\n Information Management Expert System")
    data_type = input("What kind of data are you managing? (text/image/video): ").lower()
    storage = input("Do you need long-term storage? (yes/no): ").lower()
    access = input("Do multiple people need access? (yes/no): ").lower()

    if data_type == "text" and storage == "yes" and access == "yes":
        print("Recommendation: Use a cloud-based document management system (e.g., Google Drive, SharePoint).")
    elif data_type == "image" and access == "no":
        print("Recommendation: Use local encrypted folders or photo manager software.")
    else:
        print("Recommendation: Use a hybrid system for better scalability and security.")

def hospital_diagnosis():
    print("\n Medical Diagnosis Expert System")
    fever = input("Do you have a fever? (yes/no): ").lower()
    cough = input("Do you have a cough? (yes/no): ").lower()
    rash = input("Do you have a rash? (yes/no): ").lower()

    if fever == "yes" and cough == "yes":
        print("Diagnosis: You might have the Flu or COVID-19.")
    elif fever == "yes" and rash == "yes":
        print("Diagnosis: Possible Dengue or Measles.")
    else:
        print("Diagnosis: Symptoms unclear. Please consult a doctor.")

def help_desk_system():
    print("\n Help Desk Expert System")
    issue = input("Is the issue hardware or software? ").lower()
    urgency = input("Is it urgent? (yes/no): ").lower()

    if issue == "hardware" and urgency == "yes":
        print("Action: Escalate to IT support immediately.")
    elif issue == "software":
        print("Action: Restart the application. If unresolved, reinstall.")
    else:
        print("Action: Log a ticket and monitor.")

def employee_performance():
    print("\n Employee Performance Evaluation Expert System")
    attendance = int(input("Enter attendance percentage: "))
    projects = int(input("Enter projects completed: "))
    teamwork = int(input("Enter teamwork score (1-10): "))

    if attendance >= 90 and projects >= 5 and teamwork >= 8:
        print("Performance: Excellent")
    elif attendance >= 80 and projects >= 3 and teamwork >= 6:
        print("Performance: Good")
    elif attendance >= 70:
        print("Performance: Average")
    else:
        print("Performance: Needs Improvement")

def stock_market():
    print("\ Stock Market Trading Expert System")
    trend = input("Is the market trending up or down? ").lower()
    volume = input("Is trading volume high or low? ").lower()

    if trend == "up" and volume == "high":
        print("Advice: Consider buying growth stocks.")
    elif trend == "down":
        print("Advice: Consider selling or holding defensive stocks.")
    else:
        print("Advice: Stay cautious and monitor market signals.")

def airline_schedule():
    print("\ Airline Scheduling Expert System")
    cargo = input("Is it a passenger or cargo flight? ").lower()
    demand = input("Is demand high or low? ").lower()

    if cargo == "cargo" and demand == "high":
        print("Action: Prioritize high-demand routes and maximize payload.")
    elif cargo == "passenger" and demand == "low":
        print("Action: Consolidate flights or offer promotions.")
    else:
        print("Action: Maintain regular schedule and monitor bookings.")

def main():
    while True:
        print("\n Multi-Domain Expert System")
        print("Choose a system to use:")
        print("1. Information Management")
        print("2. Hospital Diagnosis")
        print("3. Help Desk Management")
        print("4. Employee Performance Evaluation")
        print("5. Stock Market Trading")
        print("6. Airline Scheduling")
        print("7. Exit")

        choice = input("Enter your choice (1-7): ")

        if choice == "1":
            information_management()
        elif choice == "2":
            hospital_diagnosis()
        elif choice == "3":
            help_desk_system()
        elif choice == "4":
            employee_performance()
        elif choice == "5":
            stock_market()
        elif choice == "6":
            airline_schedule()
        elif choice == "7":
            print("Exiting Expert System. Goodbye!")
            break
        else:
            print("Invalid choice. Try again.")

main()
