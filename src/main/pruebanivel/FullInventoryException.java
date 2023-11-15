package pruebanivel;

public class FullInventoryException extends Exception{
    public FullInventoryException(){
        super();
    }
    public String getMessage(){
        return "Full inventory! Vendor cannot buy item";
    }
}
