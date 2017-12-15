import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Student here.
 * 
 * @author (Brayden Hall) 
 * @version (a version number or a date)
 */
public class Student extends Actor
{
    private int studentNumber;
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private double average; 
    private boolean it;
    private String upKey;
    private String downKey;
    private String leftKey;
    private String rightKey;
    private int itDelay;
    public Student( int number, String first, String last, int grade, double avg, boolean isIt )
    {
        studentNumber = number;
        firstName = first;
        lastName = last;
        gradeLevel = grade;
        average = avg;
        it = isIt;
        
        if(studentNumber == 1 )
        {
            upKey = "w";
            downKey = "s";
            leftKey = "a";
            rightKey = "d";
        }
        else if( studentNumber == 2 )
        {
            upKey = "u";
            downKey = "j";
            leftKey = "h";
            rightKey = "k";
        }
        else
        {
            upKey = "up";
            downKey = "down";
            leftKey = "left";
            rightKey = "right";
        }
        
        itDelay = 200;
       
        if( it == true )
        {
            setImage("ppl2.png");
        }
       
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public int getGradeLevel()
    {
        return gradeLevel;
    }
    
    public double getAverage()
    {
        return average;
    }
    
    public boolean itIt()
    {
        return it;
    }
    
    private void checkCollision()
    {
        Actor otherStudent = getOneIntersectingObject(Student.class);
        
        if( otherStudent != null )
        {
            if( itDelay >= 200 )
            {
                if( it == true )
                {
                    it = false;
                    setImage("ppl3.png");
                    
                }
                else
                {
                    it = true;
                    setImage("ppl2.png");
                    itDelay = 0;
                }
            }
        }
        
    }
    
    private void movement()
    {
        if ( Greenfoot.isKeyDown(upKey) )
        {
            setLocation( getX(), getY() -3 );
        }
        
        if ( Greenfoot.isKeyDown(upKey) )
        {
            setLocation( getX(), getY() +3 );
        }
        
        if ( Greenfoot.isKeyDown(upKey) )
        {
            setLocation( getX()-3, getY() );
        }
        
        if ( Greenfoot.isKeyDown(upKey) )
        {
            setLocation( getX()+3, getY() );
        }
        
    }
    
    /**
     * Act - do whatever the Student wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        checkCollision();
        movement();
        
        if( Greenfoot.mouseClicked(this) )
        {
            System.out.println( toString() );
        }
        
        if(it == true )
        {
            itDelay++;
        }
        
    }    
    
    public String toString()
    {
        return String.format("Name: %15s, %10s/nGrade: %10d/nAverage: %10.1f/n", lastName, firstName, gradeLevel, average);
    }
    
}
