package Program.Data;

public abstract class Animals {
    private String name;
    private String age;
    private String command;

    public Animals(String name, String age, String command) {
        this.name = name;
        this.age = age;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "[Имя: " + name + ", Возраст: " + age + ", Команды: " + command + "]";
    }
}