package Trivia;

/**
 * Interface for the Trivia API.
 *
 * @author Sengthida Lorvan Updated 4-2-21
 */
public interface TriviaApiInterface {

    public String category();
    
    public String gameLength(int _questions);
    
    public String difficulty();
    
}
