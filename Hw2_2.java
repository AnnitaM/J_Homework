/* Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

public class Hw2_2 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String [] data = ParseJsonString(jsonString);
        String [] info = getStudentInfo(data);
        printInfo(info);
    }
    public static String[] ParseJsonString(String jsonStringList){
        String [] data = jsonStringList.split("},");
        for (int i=0; i< data.length; i++) {
            data[i] = data[i].replace("\"", "");
            data[i] = data[i].replace("{", "");
            data[i] = data[i].replace("}", "");
            data[i] = data[i].replace("[", "");
            data[i] = data[i].replace("]", "");
            data[i] = data[i].replace("фамилия", "");
            data[i] = data[i].replace("оценка", "");
            data[i] = data[i].replace("предмет", "");
        }
        return data;
    }

    public static String[] getStudentInfo (String[] data) {
        String[] infoList = new String[data.length];
        for (int i =0; i < data.length; i++) {
            String[] studentData = data[i].split(",");
            String info = String.format("Студент %s получил %s по предмету %s.", studentData[0], studentData[1], studentData[2]);
            infoList[i] = info;
        }
        return infoList;
    }

    public static void printInfo(String[] infoList){
        for (String i: infoList) {
            System.out.println(i);
        }
    }

}
