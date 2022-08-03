package meiri;

class Solution1108 {
    public String defangIPaddr(String address) {
        String[] split = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            sb.append("[.]").append(split[i]);
        }
        return sb.toString();
    }
}