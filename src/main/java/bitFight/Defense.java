package bitFight;

public enum Defense implements Action {
    HIGHBLOCK("highblock",ActionHeight.HIGH),
    LOWBLOCK("lowblock",ActionHeight.LOW);

    private String name;
    private ActionHeight height;

    Defense(String name, ActionHeight height){
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public ActionHeight getHeight() {
        return height;
    }

    @Override
    public String getAction() {
        return "Defense";
    }

    public ActionType getActionType(){
        return ActionType.DEFENSE;
    }
}
