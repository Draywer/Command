package ru.idcore;

public class JumpCommand implements FrogCommand {
    private Frog frog;
    private int backupPosition;
    private int steps;

    public static FrogCommand jumpCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new JumpCommand(frog, steps);

    }

    private JumpCommand(Frog frog, int steps) {
        this.frog = frog;
        this.backupPosition = frog.getPosition();
        this.steps = steps;
    }

    @Override
    public boolean execute() {
        if (steps != 0) {
            frog.jump(steps);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean undo() {
        if (frog.getPosition() != backupPosition) {
            frog.setPosition(backupPosition);
            return true;
        }
        return false;
    }
}
