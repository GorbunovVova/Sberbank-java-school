import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class Task3 {
    private static LinkedList<SomeObject> list = new LinkedList<SomeObject>();

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException {
        SomeObject originalObject = new SomeObject("originalObject");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = null;
        try {
            ous = new ObjectOutputStream(baos);
        } catch (IOException e) {
            try {
                throw new CheckedException();
            } catch (CheckedException e1) {
                throw new UncheckedException();
            }
        }
        ous.writeObject(originalObject);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SomeObject clonedObject = (SomeObject) ois.readObject();
        System.out.println("originalObject.equals(clonedObject) - " + originalObject.equals(clonedObject));
        System.out.println("originalObject == clonedObject - " + (originalObject == clonedObject));
        list.add(originalObject);
        list.add(clonedObject);
        Field field = Task3.class.getDeclaredField("list");
        Type genericFieldType = field.getGenericType();
        ParameterizedType pType = (ParameterizedType) genericFieldType;
        Type[] fieldArgTypes = pType.getActualTypeArguments();
        System.out.println("type: " + fieldArgTypes[0]);
    }
}
