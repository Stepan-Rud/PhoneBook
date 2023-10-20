import java.util.*;

public class phoneBook {
        private Map<String, List<String>> map = new HashMap<>();

        void add(String phoneNum, String name) {
            if (map.containsKey(name)) {
                List<String> phoneNumbers = map.get(name);
                phoneNumbers.add(phoneNum);
            } else {
                List<String> phoneNumbers = new ArrayList<>();
                phoneNumbers.add(phoneNum);
                map.put(name, phoneNumbers);
            }
        }

        String getPhoneNum(String phoneNum) {
            StringBuilder stringBuilder = new StringBuilder();
            String result = null;
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                List<String> phoneNumbers = entry.getValue();
                if (phoneNumbers.contains(phoneNum)) {
                    stringBuilder.append(entry.getKey());
                    stringBuilder.append(" : ");
                    stringBuilder.append(entry.getValue());
                    stringBuilder.append("\n");
                }
                result = ("Список имен у которых есть данный номер предоставлен ниже: " + "\n" + stringBuilder.toString());
            }
            return result;
        }

        String getByName(String name) {
            StringBuilder stringBuilder = new StringBuilder();
            Set<String> phoneNumbersS = null;
            if (map.containsKey(name)) {
                phoneNumbersS = new HashSet<>();
//                phoneNumbers.add(String.valueOf(map.get(name)));
                List<String> phoneNumbers = map.get(name);
                for (String phoneNumber : phoneNumbers) {
                    phoneNumbersS.add(phoneNumber);
                    phoneNumbersS.add(" : ");
                    phoneNumbersS.add(name);
                }

            }
            phoneNumbersS.remove(",");
            String result = ("Список номеров с данным именем предоставлен ниже: " + "\n" + phoneNumbersS.toString().replaceAll(",", " ") + "\n");
            return result;
        }

        String getAll() {
            StringBuilder stringBuilder = new StringBuilder();
            List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
            entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
            for (Map.Entry<String, List<String>> entry : entries) {
                List<String> phoneNumbers = entry.getValue();
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" : ");
                stringBuilder.append(phoneNumbers);
                stringBuilder.append("\n");
            }
            return ("Полный список имен с номерами предоставлен ниже: " + "\n" + stringBuilder.toString());
        }
        public static void main(String[] args) {
            phoneBook phoneBook = new phoneBook();
            phoneBook.add("123456789", "Алиса");
            phoneBook.add("987654321", "Иван");
            phoneBook.add("456789123", "Владимир");
            phoneBook.add("321654987", "Давид");
            phoneBook.add("789123456", "Алексадра");
            phoneBook.add("654987321", "Сергей");
            phoneBook.add("234567891", "Иван");
            phoneBook.add("876543219", "Пётр");
            phoneBook.add("345678912", "Александра");
            phoneBook.add("432165498", "Андрей");
            phoneBook.add("876543219", "Степан");
            phoneBook.add("234567891", "Сергей");
            phoneBook.add("654987321", "Владимир");
            phoneBook.add("435455423", "Владимир");
            phoneBook.add("789123446", "Викторя");
            phoneBook.add("321654987", "Давид");
            phoneBook.add("321654988", "Давид");
            phoneBook.add("321654987", "Виталий");
            phoneBook.add("321654987", "Виталий");
            System.out.println(phoneBook.getPhoneNum("654987321"));
            System.out.println(phoneBook.getByName("Давид"));
            System.out.println(phoneBook.getAll());
        }


    }
