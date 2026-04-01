public class Komputer { //1.Mendefinisikan class bernama Komputer
    String jenis_komputer;
    private String merk; //2.jenis_komputer dan merk adalah variabel dalam class

    public void setDataKomputer(String jenis, String merk){
        jenis_komputer = jenis;
        this.merk = merk;

    } //3.Method untuk mengisi nilai atribut (setter)

    public String getJenis (){
        return jenis_komputer;
    } //4.Mengambil nilai jenis_komputer

    public String getMerk(){
        return merk;

    } //5.Mengambil nilai merk

    public static void main (String[]args){
        Komputer mykom = new Komputer (); //6.Komputer mykom = new Komputer();
        mykom.setDataKomputer ("LAPTOP","MACBOOK"); //7.Mengisi data object (LAPTOP, MACBOOK)
        System.out.println(mykom.getJenis());
        System.out.println(mykom.getMerk()); //8.Menampilkan nilai ke layar
    }
}