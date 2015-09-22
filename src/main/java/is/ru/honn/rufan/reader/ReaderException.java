package is.ru.honn.rufan.reader;

/**
 * An exception class that is thrown by the reader classes in the project.
 */
public class ReaderException extends Exception
{
  public ReaderException()
  {
    super();
  }

  public ReaderException(String message)
  {
    super(message);
  }

  public ReaderException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
