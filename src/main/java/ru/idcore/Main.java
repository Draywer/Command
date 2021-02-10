package ru.idcore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frog frog = Frog.getInstance();
        List<FrogCommand> commands = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int curCommand = -1;
        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            System.out.println("Введите действие:");
            input = scanner.nextLine();
            if (!input.equals("0")) {
                /*пользователь хочет отменить действие*/
                if (input.equals("<<")) {
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undo();
                        curCommand--;
                    }
                    /*пользователь хочет повторить действие*/
                } else if (input.equals(">>")) {
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего повторять!");
                    } else {
                        curCommand++;
                        commands.get(curCommand).execute();
                    }
                    //пользователь ввёл новое движение для лягушки
                } else {
                    FrogCommand cmd = JumpCommand.jumpCommand(frog, Integer.parseInt(input));
                    curCommand++;
                    commands.add(cmd);
                    cmd.execute();
                }
                //рисуем поле после команды
                System.out.println(frog);
            } else {
                break;
            }
        }


    }
}
