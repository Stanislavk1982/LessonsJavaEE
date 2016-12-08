package reflection;

public enum Role {
    USER(){
        @Override
        public String toString() {
            System.out.println("User");
            return "USER";
        }
    },

    ADMIN(){
        @Override
        public String toString() {
            System.out.println("Admin");
            return "ADMIN";
        }
    },
    ROOT(){
        @Override
        public String toString() {
            System.out.println("Root");
            return "ROOT";
        }
    };
}
