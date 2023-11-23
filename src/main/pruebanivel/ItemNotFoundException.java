package pruebanivel;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(){
        super();
    }
    public String getMessage(){
        return "Item not found in NPC inventory";
    }
}
