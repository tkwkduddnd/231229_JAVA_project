package sale;

import java.util.Scanner;

public interface SaleProgram {
	
	void add(Scanner scan);
	void menuPrint();
	void orderPick(Scanner scan);
	int orderSearch(Scanner scan);
	void orderPrint();	
}
