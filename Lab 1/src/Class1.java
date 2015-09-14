import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Class1 {
	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in);
		
		System.out.print("Enter how many years do you intend to work: ");
		double yearsworked = input.nextDouble();
		
		System.out.print("Enter the expected average return on investment: "+"%");
		double avgret = input.nextDouble();
		
		System.out.print("Enter how long you want to draw: ");
		double yearsret = input.nextDouble();
		
		System.out.print("Enter the annual retirement rate: ");
		double retret = input.nextDouble();
		
		System.out.print("Enter required and expected SSI income: ");
		double req = input.nextDouble();
		double SSI = input.nextDouble();
		
		double monthsworked = yearsworked * 12;
		double monthsret = yearsret * 12;
		double monthlyret = (avgret / 100) / 12;
		double monthlyretret = (retret / 100) / 12;
		
		double needed = req - SSI; 
		
		double PV = FinanceLib.pv(monthlyretret, monthsret, needed, 0, false);
		
		double PMT = FinanceLib.pmt(monthlyret, monthsworked, 0, PV, false);
		
		System.out.printf("In total, you need $%.2f saved", -PV);
		System.out.printf("You should save $%.2f every month.", PMT);
	}

}
