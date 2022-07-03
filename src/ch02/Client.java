package ch02;

class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }
    public Money getAvatarFee(){
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }
}
