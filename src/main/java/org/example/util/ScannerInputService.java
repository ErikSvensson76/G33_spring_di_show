package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService{

    private Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        boolean invalid = true;
        int number = 0;
        while(invalid){
            try{
                System.out.print("Enter a number: ");
                number = Integer.parseInt(getString().trim());
                invalid = false;
            }catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
        }
        return number;
    }
}
