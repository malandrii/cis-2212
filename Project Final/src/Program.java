// Andrii Malakhovtsev
// December 9, 2024
// The Company

public class Program
    {
        public static void main(String[] args)
        {
            PayrollManager pm = new PayrollManager("data.txt");
            if (pm.loadData()) {
               pm.runPayroll();
            }
        }
    }
