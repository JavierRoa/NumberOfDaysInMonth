public class NumberOfDaysInMonth {
    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }

    // Función año bisiesto.
    private static boolean isLeapYear (int year) {
        /* Primera condición: Validación de años permitidos.
           Segunda condición: Comprobación de año bisiesto no divisible por 4 y no por 100.
           Tercera condición: Comprobación de año bisiesto divisible por 400.
         */
        return  (year>0 && year<10000) && ((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0));
    }

    // Función número de días en el mes.
    private static int getDaysInMonth(int month, int year) {
        if((month<1 || month>12) || (year<0 || year>9999))  { // Validación parámetros válidos.
            return -1;
        }
        boolean isLeapYear = isLeapYear(year); // Llamado función año bisiesto.
        return switch (month) { // Retorno número de días según mes y año.
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                if (isLeapYear) {
                    yield 29;
                }
                yield 28;
            }
            default -> -1;
        };
    }
}
