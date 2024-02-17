public class DefaultMethodInterfaceExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        printInfoAboutVehicle(car);
        printInfoAboutVehicle(bicycle);
    }

    private static void printInfoAboutVehicle(Vehicle vehicle){
        System.out.println("Vehicle is "+vehicle.getClass().getName()+" which has "+vehicle.getWheels()+" wheels and brand is "+vehicle.getBrand()+" which sounds like "+vehicle.hornSound());
    }
}



interface Vehicle{
    int getWheels();
    String getBrand();

    default String hornSound(){
        return "Honk Honk";
    }

}

class Car implements Vehicle{

    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public String getBrand() {
        return "Mercedes Benz";
    }
}

class Bicycle implements Vehicle{

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public String getBrand() {
        return "Firefox";
    }

    @Override
    public String hornSound() {
        return "Triin-Triin";
    }
}