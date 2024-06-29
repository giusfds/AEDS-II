
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Personagem 
{
    // atributos
    private String id;
    private String name;
    private String[] alternativeNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private LocalDate dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;

    public Personagem() {
        this.id = "";
        this.name = "";
        this.alternativeNames = new String[0];
        this.house = "";
        this.ancestry = "";
        this.species = "";
        this.patronus = "";
        this.hogwartsStaff = false;
        this.hogwartsStudent = false;
        this.actorName = "";
        this.alive = false;
        this.dateOfBirth = LocalDate.now();
        this.yearOfBirth = 0;
        this.eyeColour = "";
        this.gender = "";
        this.hairColour = "";
        this.wizard = false;
    }

    public Personagem(String id, String name, String[] alternativeNames, String house, String ancestry, String species, String patronus, Boolean hogwartsStaff, Boolean hogwartsStudent, String actorName, Boolean alive, LocalDate dateOfBirth, int yearOfBirth, String eyeColour, String gender, String hairColour, Boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternativeNames = alternativeNames;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    // Métodos get
    public String getId() { return id; }
    public String getName() { return name; }
    public String[] getAlternativeNames() { return alternativeNames; }
    public String getHouse() { return house; }
    public String getAncestry() { return ancestry; }
    public String getSpecies() { return species; }
    public String getPatronus() { return patronus; }
    public Boolean getHogwartsStaff() { return hogwartsStaff; }
    public Boolean getHogwartsStudent() { return hogwartsStudent; }
    public String getActorName() { return actorName; }
    public Boolean getAlive() { return alive; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public String getEyeColour() { return eyeColour; }
    public String getGender() { return gender; }
    public String getHairColour() { return hairColour; }
    public Boolean getWizard() { return wizard; }
    
    // Métodos set
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAlternativeNames(String[] alternativeNames) { this.alternativeNames = alternativeNames; }
    public void setHouse(String house) { this.house = house; }
    public void setAncestry(String ancestry) { this.ancestry = ancestry; }
    public void setSpecies(String species) { this.species = species; }
    public void setPatronus(String patronus) { this.patronus = patronus; }
    public void setHogwartsStaff(Boolean hogwartsStaff) { this.hogwartsStaff = hogwartsStaff; }
    public void setHogwartsStudent(Boolean hogwartsStudent) { this.hogwartsStudent = hogwartsStudent; }
    public void setActorName(String actorName) { this.actorName = actorName; }
    public void setAlive(Boolean alive) { this.alive = alive; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setEyeColour(String eyeColour) { this.eyeColour = eyeColour; }
    public void setGender(String gender) { this.gender = gender; }
    public void setHairColour(String hairColour) { this.hairColour = hairColour; }
    public void setWizard(Boolean wizard) { this.wizard = wizard; }


    // ler a string toda
    public void ler(String line) {
        String[] lineSplitted = line.split(";");

        this.setId(lineSplitted[0].trim());
        this.setName(lineSplitted[1].trim());

        String[] alternativesNamesSplitted = lineSplitted[2].split(",");
        ArrayList<String> altenativesNamesCleaned = new ArrayList<String>();
        for(int i = 0; i < alternativesNamesSplitted.length; i++) {
            String alternateNameCleaned = cleanWord(alternativesNamesSplitted[i].trim());
            if(!alternateNameCleaned.isEmpty()) {
                altenativesNamesCleaned.add(alternateNameCleaned);
            }
        }
        this.setAlternativeNames(altenativesNamesCleaned.toArray(new String[altenativesNamesCleaned.size()]));

        this.setHouse(lineSplitted[3].trim());
        this.setAncestry(lineSplitted[4].trim());
        this.setSpecies(lineSplitted[5].trim());
        this.setPatronus(lineSplitted[6].trim());
        this.setHogwartsStaff(isBoolean(lineSplitted[7].trim()));
        this.setHogwartsStudent(isBoolean(lineSplitted[8].trim()));
        this.setActorName(lineSplitted[9].trim());
        this.setAlive(isBoolean(lineSplitted[10].trim()));
        this.setDateOfBirth(dateBirthLocalDate(lineSplitted[12].trim()));
        this.setYearOfBirth(Integer.parseInt(lineSplitted[13].trim()));
        this.setEyeColour(lineSplitted[14].trim());
        this.setGender(lineSplitted[15].trim());
        this.setHairColour(lineSplitted[16].trim());
        this.setWizard(isBoolean(lineSplitted[17].trim()));
    }

    private boolean isBoolean(String str){
        if (str.equals("FALSO")) {
            return false;
        }else{
        return true;
        }
    }

    private LocalDate dateBirthLocalDate(String line){
        return LocalDate.parse(line, DateTimeFormatter.ofPattern("dd-M-yyyy"));
    }

    private String cleanWord(String word) {
        String newWord = new String();
        int len = word.length();
        for(int i = 0; i < len; i++) {
            if(word.charAt(i) != '[' &&
            word.charAt(i) != ']' &&
            word.charAt(i) != '\''){
            newWord += word.charAt(i);
            } 
        }
        return newWord;
    }

    public Personagem clone(){
        Personagem clone = new Personagem();
        clone.id = this.id;
        clone.name = this.name;
        clone.alternativeNames = this.alternativeNames;
        clone.house = this.house;
        clone.ancestry = this.ancestry;
        clone.species = this.species;
        clone.patronus = this.patronus;
        clone.hogwartsStaff = this.hogwartsStaff;
        clone.hogwartsStudent = this.hogwartsStudent;
        clone.actorName = this.actorName;
        clone.alive = this.alive;
        clone.dateOfBirth = this.dateOfBirth;
        clone.eyeColour = this.eyeColour;
        clone.gender = this.gender;
        clone.hairColour = this.hairColour;
        clone.wizard = this.wizard;
        return clone;
    }

    private String StringArrayAsString(String[] array) {
        String result = "{";
        for (int i = 0; i < array.length; i++) {
            if(i < array.length - 1) {
                result += array[i] + ", ";
            } else {        
                result += array[i];
            }
        }
        result += "}";
        return result;
    }

    public String toString() {
        String formattedDate = this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "[" + getId() + " ## " + getName() + " ## " + StringArrayAsString(getAlternativeNames()) + " ## " + getHouse() + " ## " + getAncestry() + " ## " + getSpecies() + " ## " + getPatronus() + " ## " + getHogwartsStaff() + " ## " + getHogwartsStudent() + " ## " + getActorName() + " ## " + getAlive() + " ## " + formattedDate + " ## " + getYearOfBirth() + " ## " + getEyeColour() + " ## " + getGender() + " ## " + getHairColour() + " ## " + getWizard() + "]";
    }
}

class Timer {
    private Instant inicio, fim;

    public Timer() {}
    public void Start() { this.inicio = Instant.now(); }
    public void Stop() { this.fim = Instant.now(); }
    public double Time() { return Duration.between(inicio, fim).getNano() / 1000000000.0; }

}

class Log {
		private int comparacoes, movimentacoes;

		public Log() {
			this(0, 0);
		}
		
		public Log(int comparacoes, int movimentacoes) {
			this.comparacoes = comparacoes;
			this.movimentacoes = movimentacoes;
		}

		public void pesquisa(String fileName, Timer timer) throws Exception {

			PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));

			printWriter.printf("Matrícula: 801779\t");
			printWriter.printf("Tempo de execução: %fs\t", timer.Time());
			printWriter.printf("Número de comparações: %d", comparacoes);

			printWriter.close();
				
		}

		public void ordenacao(String fileName, Timer timer) throws Exception {

			PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));

			printWriter.printf("Matrícula: 801779\t");
			printWriter.printf("Tempo de execução: %fs\t", timer.Time());
			printWriter.printf("Número de comparações: %d\t", comparacoes);
			printWriter.printf("Número de movimentações: %d", movimentacoes);

			printWriter.close();
				
		}

		public void addComp() { this.comparacoes++; }
		public void addComp(int incremento) { this.comparacoes += incremento; }
		public void addMove() { this.movimentacoes++; }
		public void addMove(int incremento) {
			this.movimentacoes += incremento;
		}
}

public class MergeSort {

    public static void ordernarMergeSort(ArrayList<Personagem> personagens, int esq, int meio, int dir) throws IOException {
    int n1 = meio - esq + 1;
    int n2 = dir - meio;

    ArrayList<Personagem> a1 = new ArrayList<>();
    ArrayList<Personagem> a2 = new ArrayList<>();

    for (int i = 0; i < n1; i++) {
        a1.add(personagens.get(esq + i));
    }

    for (int j = 0; j < n2; j++) {
        a2.add(personagens.get(meio + j + 1));
    }

    int i = 0, j = 0, k = esq;
    while (i < n1 && j < n2) {
        if (a1.get(i).getActorName().compareTo(a2.get(j).getActorName()) < 0) {
            personagens.set(k, a1.get(i));
            i++;
        } else if(a1.get(i).getActorName().compareTo(a2.get(j).getActorName()) == 0){
            if(a1.get(i).getName().compareTo(a2.get(j).getName()) < 0){
                personagens.set(k, a1.get(i));
                i++;
            }else{
                personagens.set(k, a2.get(j));
                j++;
            }
        }else {
            personagens.set(k, a2.get(j));
            j++;
        }
        k++;
    }

    while (i < n1) {
        personagens.set(k, a1.get(i));
        i++;
        k++;
    }

    while (j < n2) {
        personagens.set(k, a2.get(j));
        j++;
        k++;
    }
}

    public static void mergesort(ArrayList<Personagem> personagens, int esq, int dir) throws IOException {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(personagens, esq, meio);
            mergesort(personagens, meio + 1, dir);
            ordernarMergeSort(personagens, esq, meio, dir);
        }
    }


    private static boolean EOF (RandomAccessFile rf)throws Exception{
        return rf.getFilePointer() != rf.length();
    }

    public static void main(String[] args)throws Exception {
        RandomAccessFile RF = new RandomAccessFile("/tmp/characters.csv", "r");
        Scanner sc = new Scanner(System.in);
        Timer timer = new Timer();
        Log log = new Log();
        ArrayList<Personagem> BD = new ArrayList<>();
        ArrayList<Personagem> BD2 = new ArrayList<>();
        String str = "";
        // trazendo do arquivo para variavel
        RF.readLine(); // Despresando a primeira linha do CSV
        while (EOF(RF)) {
            Personagem p = new Personagem();
            str = RF.readLine();    
            p.ler(str);
            BD.add(p);
        }
        // id pub.in
        // lendo os id do pub.in
        while (!(str=sc.nextLine()).equals("FIM") ) {
            // fazer pesquisa sequencial por id
            for (Personagem personagem : BD) {
                if (str.equals(personagem.getId())) {
                    BD2.add(personagem);
                }
            }
        }

        timer.Start();
        mergesort(BD2, 0 , BD2.size() - 1);
        timer.Stop();

        for (Personagem personagem : BD2) {
            System.out.println(personagem);
        }

        log.pesquisa("801779_mergesort.txt", timer);

        RF.close();
        sc.close();
    }
}