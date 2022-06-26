import java.util.Scanner;
public class AirplaneMenu
{
    //instance field
    private Airplane objAirplane;

    //default constructor
    public AirplaneMenu()
    {
        objAirplane = new Airplane();
    }

    //runs the airplane menu
    public void run()
    {
        //creates airplane layout
        objAirplane.createClasses();
        String choice = "";
        while (!choice.equals("Q"))
        {
            //prints menu
            System.out.println("A)dd\tS)how\tQ)uit");

            //get user input
            Scanner userInput = new Scanner(System.in);
            choice = userInput.nextLine().toUpperCase();
            if(choice.equals("A"))
            {
                String airplaneClass = "";
                String seatChoice = "";
                int passengers = 0;

                System.out.println("F)irst\tE)conomy");
                airplaneClass = userInput.nextLine().toUpperCase();
                if(airplaneClass.equals("F"))
                {
                    System.out.println("Passengers? (1-2)");
                    passengers = userInput.nextInt();
                    if(passengers < 2)
                    {
                        Scanner inputValue = new Scanner(System.in);
                        System.out.println("A)isle\tW)indow");
                        seatChoice = inputValue.nextLine().toUpperCase();
                    }


                    //add seats
                    objAirplane.addSeat("F", passengers, seatChoice);
                }
                else if(airplaneClass.equals("E"))
                {
                    System.out.println("Passengers? (1-3)");
                    passengers = userInput.nextInt();
                    if (passengers < 3)
                    {
                        Scanner input1 = new Scanner(System.in);
                        System.out.println("A)isle\tC)enter\tW)indow");
                        seatChoice = input1.nextLine().toUpperCase();
                    }

                    //add seats
                    objAirplane.addSeat("E", passengers, seatChoice);
                }
            }
            //shows seating
            else if(choice.equals("S"))
            {
                System.out.println(objAirplane.displaySeats());
            }
            System.out.println();
        }
    }
}