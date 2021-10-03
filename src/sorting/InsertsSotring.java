package sorting;

class InsertsTest {

    static class Student implements Comparable<Student>{
        String name;
        int id;
        double averageMark;

        public Student(String name, int id, double averageMark) {
            this.name = name;
            this.id = id;
            this.averageMark = averageMark;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static Student [] initStudents(){
            return new Student[]{
                    new Student("Jack", 1, 2.55),
                    new Student("Zoe", 22, 5.66),
                    new Student("Oleg", 12, 4.66),
                    new Student("Vova", 77, 3.67),
                    new Student("Egor", 4, 2.55),
                    new Student("Ivan", 0, 1.55),
                    new Student("Artur", 23, 5.66),
                    new Student("Zhenya", 11, 4.23),
                    new Student("Alisa", 73, 3.55),
                    new Student("Anya", 34, 2.99),
                    new Student("Jack", 44, 1.66)
            };
        }

        static Student [] initStudents2(){
            return new Student[]{
                    new Student("Zoe", 84, 5.55),
                    new Student("Anya", 12, 4.66),
                    new Student("Ivan", 24, 3.66),
                    new Student("Ivan", 13, 2.67),
                    new Student("Ivan", 9999, 1.55),
            };
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.id, o.id);
        }

        public static void swapStudents(Student [] students, int i, int j){
            if(i != j) {
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", averageMark=" + averageMark +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student [] students = Student.initStudents();

        int flag = 0;
        while(flag < students.length){
            Student min = students[flag];
            int minPos = flag;
            for(int i = flag + 1; i < students.length; i++){
                if(students[i].compareTo(min) < 0) {
                    min = students[i];
                    minPos = i;
                }
            }
            Student.swapStudents(students, flag, minPos);
            flag++;
        }
        for(Student item : students)
            System.out.println(item);
    }
}