public class Main {

    public String encryption(String msg, int key){
        StringBuilder newMsg = new StringBuilder();
        int asc, newAsc;
        for (int i = 0; i < msg.length(); i++){
            asc = msg.charAt(i);
            newAsc = asc + key;
            newMsg.append((char) newAsc);
        }
        return newMsg.toString();
    }

    public String decryption(String text, int key){
        StringBuilder newMsg = new StringBuilder();
        int asc, newAsc;
        for (int i = 0; i < text.length(); i++){
            asc = text.charAt(i);
            newAsc = asc - key;
            newMsg.append((char) newAsc);
        }
        return newMsg.toString();
    }

    public static void main(String[] args) {
        Main code = new Main();
        String mode = organize(args)[0];
        String data = organize(args)[1];
        String key = organize(args)[2];

        try{
            if (mode.equals("enc")) System.out.println(code.encryption(data, Integer.parseInt(key)));
            else if (mode.equals("dec")) System.out.println(code.decryption(data, Integer.parseInt(key)));
            else System.out.println("Wrong target operation!");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getClass().getName());
        }
    }

    static String[] organize(String[] arguments) {
        String mode = "enc", data = "", key = "0";
        for (int i = 0; i < arguments.length; i++) {
            switch (arguments[i]) {
                case "-mode" -> {
                    mode = arguments[i + 1];
                    i++;
                }
                case "-key" -> {
                    key = arguments[i + 1];
                    i++;
                }
                case "-data" -> {
                    data = arguments[i + 1];
                    i++;
                }
            }
        }
        return new String[]{mode, data, key};
    }
}