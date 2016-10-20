import java.io.*;

public class Formatter {
    public static void formatter(String way) throws IOException {//метод formater получает путь к файлу и форматирует его содержимое
        File file = new File(way);//получает файл по указоному пути
        BufferedReader reader = new BufferedReader(new FileReader(file));//создается поток ввода
        int indent = 0;//счетчик открывающихся скобок '{'
        String line;//строка потока ввода
        String newString = "";//отформатированный текст
        String space = "";//количество пробелов зависищих от количествао открывающихся скобок'{'
        while ((line = reader.readLine()) != null) {//считывается и проверяется на содержимое очередная строка входного текста
            line = line.trim();//удаляются пробелы перед строкой
            char[] buffer = new char[line.length()]; //создается массив символов
            buffer = line.toCharArray();//в массив buffer помещаются символы строки
            for (int i = 0; i < buffer.length; i++) {

                if (!(buffer[i]=='{' | buffer[i] == '}' | buffer[i] == ';'| buffer[i] ==buffer.length-1)) {

                    newString = newString + buffer[i];
                }

                else{
                    if(buffer[i]=='{'){
                        indent = indent+4;
                        space="";
                        for(int a = indent;a>0;a--){
                            space = space + " ";
                        }
                        newString = newString+buffer[i]+"\r\n"+space;
                    }
                    if(buffer[i]=='}'){
                        indent = indent-4;
                        space="";
                        for(int a = indent;a>0;a--){
                            space = space + " ";
                        }
                        newString = newString+"\r\n"+space+buffer[i]+"\r\n"+space;
                    }
                    if(buffer[i]==';'){
                        newString = newString+buffer[i]+"\r\n"+space;
                    }
                }
            }

        }
        System.out.print(newString);
        FileWriter wreiter = new FileWriter(file);
        wreiter.write(newString);//В файл записывается отформатированный текст
        wreiter.close();




    }
}

