package ru.idcore;

public class JumpCommand implements FrogCommand {
    private Frog frog;
    private int backupPosition;
    private int steps;
    private boolean isCanceled = false;


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

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
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
            isCanceled = true;
            return true;
        }
        return false;
    }
}
