/* Class demonstrating the use of custom exceptions*/



package employees;


@SuppressWarnings("serial")
class Age_exception extends Exception{

	//parameterless constructor
	public Age_exception() {}
	//Constructor that accepts a message
	public Age_exception(String message)
    {
       super(message);
    }
}

