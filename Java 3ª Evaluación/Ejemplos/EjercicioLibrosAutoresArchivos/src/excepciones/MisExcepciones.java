package excepciones;

//@author 

public class MisExcepciones extends Exception {
    
    private String error;
    
    
    public MisExcepciones () {}
    
    public MisExcepciones (String error) {
        
        super(error);
        this.error=error;
        
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
