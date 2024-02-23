package learn;


public class Test {

    Integer id;
    String value;

    public Test(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Test() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder{
        Integer id;
        String value;

        public Builder id(Integer id){
            this.id=id;
            return this;
        }
        public Builder value(String value){
            this.value=value;
            return this;
        }

        public Test build(){
            return new Test(this.id,this.value);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

    public static void main(String[] args) {
        Test build = Test.builder().id(1).value("123").build();
    }
}
