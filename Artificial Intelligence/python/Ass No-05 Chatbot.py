def pizza_bot():
    print("🍕 Welcome to PizzaBot!")
    print("How can I help you today? (Type 'quit' to exit)\n")

    while True:
        user_input = input("You: ").lower()
        
        if "quit" in user_input or "bye" in user_input:
            print("PizzaBot: Thanks for chatting! Have a cheesy day!")
            break

        elif "menu" in user_input or "show" in user_input:
            print("PizzaBot: Here's our menu:\n- Margherita\n- Pepperoni\n- Veggie\n- BBQ Chicken")

        elif "order" in user_input or "want" in user_input:
            print("PizzaBot: Great! What pizza would you like to order?")

        elif "margherita" in user_input:
            print("PizzaBot: Margherita pizza added to your order!")

        elif "pepperoni" in user_input:
            print("PizzaBot: Pepperoni pizza added to your order!")

        elif "veggie" in user_input:
            print("PizzaBot: Veggie pizza added to your order!")

        elif "bbq" in user_input or "chicken" in user_input:
            print("PizzaBot: BBQ Chicken pizza added to your order!")

        elif "price" in user_input or "cost" in user_input:
            print("PizzaBot: All pizzas are ₹299 each.")

        elif "thanks" in user_input or "thank you" in user_input:
            print("PizzaBot: You're welcome! 😊")

        else:
            print("PizzaBot: Sorry, I didn’t understand that. You can ask about our menu, prices, or place an order.")

pizza_bot()
