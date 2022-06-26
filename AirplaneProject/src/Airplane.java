public class Airplane
{
    public final int TOTAL_ROWS_FIRST = 5;
    public final int SEATS_FIRST = 4;

    public final int TOTAL_ROWS_ECON = 15;
    public final int SEATS_ECON = 6;

    //string array to hold seats
    private String[][] fClass;
    private String[][] eClass;

    //default constructor
    public Airplane()
    {
        fClass = new String[TOTAL_ROWS_FIRST][SEATS_FIRST];
        eClass = new String[TOTAL_ROWS_ECON][SEATS_ECON];
    }

    //initialize arrays for classes
    public void createClasses()
    {
        //first class
        for(int i = 0; i < fClass.length; i++)
        {
            for(int j = 0; j < fClass[i].length; j++)
            {
                fClass[i][j] = "";
            }
        }
        //economy class
        for(int i = 0; i < eClass.length; i++)
        {
            for(int j = 0; j < eClass[i].length; j++)
            {
                eClass[i][j] = "";
            }
        }
    }


    //add seats
    public void addSeat(String seatClass, int passengers, String choice)
    {
        if(seatAvailable(seatClass, passengers, choice))
        {
            if (seatClass.equals("F")) {
                firstClassSeat(passengers, choice);
            } else if (seatClass.equals("E")) {
                econClassSeat(passengers, choice);
            }
        }
        else
        {
            System.out.println("No match exists. Seat unavailable.");
        }
    }

    //add first class seats
    public void firstClassSeat(int passengers, String seatChoice)
    {
        if(passengers == 1)
        {
            for (int i = 0; i < fClass.length; i++)
            {
                if(seatChoice.equals("W"))
                {
                    if(fClass[i][0].equals(""))
                    {
                        fClass[i][0] = "*";
                        return;
                    }
                    else if(fClass[i][3].equals(""))
                    {
                        fClass[i][3] = "*";
                        return;
                    }

                }
                else if(seatChoice.equals("A"))
                {
                    if(fClass[i][1].equals(""))
                    {
                        fClass[i][1] = "*";
                        return;
                    }
                    else if(fClass[i][2].equals(""))
                    {
                        fClass[i][2] = "*";
                        return;
                    }
                }
            }
        }
        else if(passengers == 2)
        {
            for(int i = 0; i < fClass.length; i++)
            {
                if(fClass[i][0].equals("") && fClass[i][1].equals(""))
                {
                    fClass[i][0] = "*";
                    fClass[i][1] = "*";
                    return;
                }
                else if(fClass[i][2].equals("") && fClass[i][3].equals(""))
                {
                    fClass[i][2] = "*";
                    fClass[i][3] = "*";
                    return;
                }
            }
        }
    }

    //add economy class seats
    public void econClassSeat(int passengers, String seatChoice)
    {
        if(passengers == 1)
        {
            for(int i = 0; i < eClass.length; i++)
            {
                if(seatChoice.equals("W"))
                {
                    if(eClass[i][0].equals(""))
                    {
                        eClass[i][0] = "*";
                        return;
                    }
                    else if(eClass[i][5].equals(""))
                    {
                        eClass[i][5] = "*";
                        return;
                    }

                }
                else if(seatChoice.equals("C"))
                {
                    if(eClass[i][1].equals(""))
                    {
                        eClass[i][1] = "*";
                        return;
                    }
                    else if(eClass[i][4].equals(""))
                    {
                        eClass[i][4] = "*";
                        return;
                    }

                }
                else if(seatChoice.equals("A"))
                {
                    if(eClass[i][2].equals(""))
                    {
                        eClass[i][2] = "*";
                        return;
                    }
                    else if(eClass[i][3].equals(""))
                    {
                        eClass[i][3] = "*";
                        return;
                    }

                }
            }
        }
        else if(passengers == 2)
        {
            for(int i = 0; i < eClass.length; i++)
            {
                if(seatChoice.equals("W") || seatChoice.equals("C"))
                {
                    if(eClass[i][0].equals("") && eClass[i][1].equals(""))
                    {
                        eClass[i][0] = "*";
                        eClass[i][1] = "*";
                        return;
                    }
                    else if(eClass[i][4].equals("") && eClass[i][5].equals(""))
                    {
                        eClass[i][4] = "*";
                        eClass[i][5] = "*";
                        return;
                    }

                }
                else if(seatChoice.equals("A") || seatChoice.equals("C"))
                {
                    if(eClass[i][1].equals("") && eClass[i][2].equals(""))
                    {
                        eClass[i][1] = "*";
                        eClass[i][2] = "*";
                        return;
                    }
                    else if(eClass[i][3].equals("") && eClass[i][4].equals(""))
                    {
                        eClass[i][3] = "*";
                        eClass[i][4] = "*";
                        return;
                    }

                }
            }
        }
        else if (passengers == 3)
        {
            for(int i = 0; i < eClass.length; i++)
            {
                if(eClass[i][0].equals("") && eClass[i][1].equals("") && eClass[i][2].equals(""))
                {
                    eClass[i][0] = "*";
                    eClass[i][1] = "*";
                    eClass[i][2] = "*";
                    return;
                }
                else if(eClass[i][3].equals("") && eClass[i][4].equals("") && eClass[i][5].equals(""))
                {
                    eClass[i][3] = "*";
                    eClass[i][4] = "*";
                    eClass[i][5] = "*";
                    return;
                }

            }
        }
    }

    //checks if there are matches to the requested seats
    public boolean seatAvailable(String planeClass, int passengers, String choice)
    {
        boolean seatAvailable = false;
        if(planeClass.equals("F"))
        {
            seatAvailable = firstClassSeatAvailable(passengers, choice);
        }
        else
        {
            seatAvailable = econClassSeatAvailable(passengers, choice);
        }
        return seatAvailable;
    }

    //checks if seat availability in first class
    public boolean firstClassSeatAvailable(int passengers, String seatChoice)
    {
        boolean available = false;
        int i = 0;
        if(passengers == 1) {
            while (!available && i < fClass.length) {
                if (seatChoice.equals("W")) {
                    if (fClass[i][0].equals("") || fClass[i][3].equals("")) {
                        available = true;
                    }
                } else if (seatChoice.equals("A")) {
                    if (fClass[i][1].equals("") || (fClass[i][2].equals(""))) {
                        available = true;
                    }
                }
                i++;
            }
        }
        else if(passengers == 2)
        {
            while(!available && i < fClass.length)
            {
                if((fClass[i][0].equals("") && fClass[i][1].equals(""))
                        || (fClass[i][2].equals("") && fClass[i][3].equals("")))
                {
                    available = true;
                }
                i++;
            }
        }
        return available;
    }

    //checks seat availability in economy class
    public boolean econClassSeatAvailable(int passengers, String seatPref)
    {
        boolean available = false;
        int i = 0;
        if(passengers == 1) {
            while (!available && i < fClass.length) {
                if (seatPref.equals("W")) {
                    if (eClass[i][0].equals("") || eClass[i][5].equals("")) {
                        available = true;
                    }
                } else if (seatPref.equals("C")) {
                    if (eClass[i][1].equals("") || eClass[i][4].equals("")) {
                        available = true;
                    }
                } else if (seatPref.equals("A")) {
                    if (eClass[i][2].equals("") || eClass[i][3].equals("")) {
                        available = true;
                    }
                }
                i++;
            }
        }
        else if(passengers == 2)
        {
            while(!available && i < fClass.length)
            {
                if(seatPref.equals("W") || seatPref.equals("C"))
                {
                    if((eClass[i][0].equals("") && eClass[i][1].equals(""))
                            || (eClass[i][4].equals("") && eClass[i][5].equals("")))
                    {
                        available = true;
                    }
                }
                else if(seatPref.equals("A") || seatPref.equals("C"))
                {
                    if((eClass[i][1].equals("") && eClass[i][2].equals(""))
                            || (eClass[i][3].equals("") && eClass[i][4].equals("")))
                    {
                        available = true;
                    }
                }
                i++;
            }
        }
        else if(passengers == 3)
        {
            while(!available && i < fClass.length)
            {
                if((eClass[i][0].equals("") && eClass[i][1].equals("") && eClass[i][2].equals(""))
                        || (eClass[i][3].equals("") && eClass[i][4].equals("") && eClass[i][5].equals("")))
                {
                    available = true;
                }
                i++;
            }
        }
        return available;
    }

    //seat layout for plane
    public String displaySeats()
    {
        String seatLayout = "";
        for (int i = 0; i < fClass.length; i++)
        {
            if(i < 6)
                seatLayout+= " ";
            seatLayout += (i + 1)+ ":";
            for(int j = 0; j < fClass[i].length; j++)
            {
                seatLayout += fClass[i][j] + " ";
            }
            seatLayout += "\n";
        }

        for(int a = 0; a < eClass.length; a++)
        {
            if(a < 4)
                seatLayout += " ";
            seatLayout += (a + TOTAL_ROWS_FIRST + 1) + ":";
            for(int b = 0; b < eClass[a].length; b++)
            {
                if(b == 3)
                    seatLayout += " ";
                seatLayout += eClass[a][b];
            }
            seatLayout += "\n";
        }
        return seatLayout;
    }

}