package TP03.Q11;


import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;

class Celula
{
    Personagem perso;
    Celula     ant;
    Celula     prox;

    public Celula ( )
    {
        this( null );
    } // end Celula ( )

    public Celula ( Personagem personagem )
    {
        this.perso = personagem;
        this.ant = this.prox = null;
    } // end Celula ( )
} // end class Celula


class Lista
{
    Celula primeiro;
    Celula ultimo;
    int tamanho;

    public Lista (  )
    {
        primeiro = new Celula( null );
        ultimo = primeiro;
        tamanho = 0;
    } // end Lista ( )

    public void inserirFim ( Personagem personagem )
    {
        ultimo.prox = new Celula( personagem );
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
        tamanho++;
    } // end inserirFim ( )

    public void mostrar ( )
    {
        for( Celula i = primeiro.prox; i != null; i = i.prox ) 
        {
            i.perso.imprimir( );
        } // end for
    } // end mostrar
} // end class Lista

class Personagem 
{
    private String    id              ; 
    private String    name            ; 
    private String[]  alternateNames  ; 
    private String    house           ; 
    private String    ancestry        ; 
    private String    species         ; 
    private String    patronus        ; 
    private Boolean   hogwartsStaff   ;  
    private Boolean   hogwartsStudent ;  
    private String    actorName       ; 
    private Boolean   alive           ;
    private String[]  alternateActors ;
    private LocalDate dateOfBirth     ; 
    private int       yearOfBirth     ; 
    private String    eyeColour       ; 
    private String    gender          ; 
    private String    hairColour      ; 
    private Boolean   wizard          ; 


    Personagem ( )
    {
        this.id              = ""    ;              
        this.name            = ""    ;            
        this.alternateNames  = null  ; 
        this.house           = ""    ;           
        this.ancestry        = ""    ;        
        this.species         = ""    ;         
        this.patronus        = ""    ;        
        this.hogwartsStaff   = false ;   
        this.hogwartsStudent = false ; 
        this.actorName       = ""    ;       
        this.alive           = false ;
        this.alternateActors = null  ;           
        this.dateOfBirth     = LocalDate.of(-1, 1, 1);
        this.yearOfBirth     = -1    ;     
        this.eyeColour       = ""    ;       
        this.gender          = ""    ;          
        this.hairColour      = ""    ;      
        this.wizard          = false ;          
    } // Personagem ( )

    /**
     *  Construtor Alternativo.
     *  Inicializando todos os atributos com os valores passados.
     */
    Personagem ( String    id         , String  name         , String[]  alternateNames , 
                 String    house      , String  ancestry     , String    species        , 
                 String    patronus   , Boolean hogwartsStaff, Boolean   hogwartsStudent, 
                 String    actorName  , Boolean alive        , String[]  alternateActors,
                 LocalDate dateOfBirth, int     yearOfBirth  , String    eyeColour      , 
                 String    gender     , String  hairColour   , Boolean   wizard )
    {
        this.id              = id              ;
        this.name            = name            ;
        this.alternateNames  = alternateNames  ;
        this.house           = house           ;
        this.ancestry        = ancestry        ;
        this.species         = species         ;
        this.patronus        = patronus        ;
        this.hogwartsStaff   = hogwartsStaff   ;
        this.hogwartsStudent = hogwartsStudent ;
        this.actorName       = actorName       ;
        this.alive           = alive           ;
        this.alternateActors = alternateActors ;
        this.dateOfBirth     = dateOfBirth     ;
        this.yearOfBirth     = yearOfBirth     ;
        this.eyeColour       = eyeColour       ;
        this.gender          = gender          ;
        this.hairColour      = hairColour      ;
        this.wizard          = wizard          ;
    } // end Personagem ( )

    public String    getId              ( ) { return ( this.id              ); }
    public String    getName            ( ) { return ( this.name            ); }
    public String[]  getAlternateNames  ( ) { return ( this.alternateNames  ); }
    public String    getHouse           ( ) { return ( this.house           ); }
    public String    getAncestry        ( ) { return ( this.ancestry        ); }
    public String    getSpecies         ( ) { return ( this.species         ); }
    public String    getPatronus        ( ) { return ( this.patronus        ); }
    public Boolean   getHogwartsStaff   ( ) { return ( this.hogwartsStaff   ); }
    public Boolean   getHogwartsStudent ( ) { return ( this.hogwartsStudent ); }
    public String    getActorName       ( ) { return ( this.actorName       ); }
    public Boolean   getAlive           ( ) { return ( this.alive           ); }
    public String[]  getAlternateActors ( ) { return ( this.alternateActors ); }
    public LocalDate getDateOfBirth     ( ) { return ( this.dateOfBirth     ); }
    public int       getYearOfBirth     ( ) { return ( this.yearOfBirth     ); }
    public String    getEyeColour       ( ) { return ( this.eyeColour       ); }
    public String    getGender          ( ) { return ( this.gender          ); }
    public String    getHairColour      ( ) { return ( this.hairColour      ); }
    public Boolean   getWizard          ( ) { return ( this.wizard          ); }
    
    
    public void setId              ( String    id              ) { this.id              = id              ; }
    public void setName            ( String    name            ) { this.name            = name            ; }
    public void setAlternateNames  ( String[]  alternateNames  ) { this.alternateNames  = alternateNames  ; } 
    public void setHouse           ( String    house           ) { this.house           = house           ; }
    public void setAncestry        ( String    ancestry        ) { this.ancestry        = ancestry        ; }
    public void setSpecies         ( String    species         ) { this.species         = species         ; }
    public void setPatronus        ( String    patronus        ) { this.patronus        = patronus        ; }
    public void setHogwartsStaff   ( Boolean   hogwartsStaff   ) { this.hogwartsStaff   = hogwartsStaff   ; }
    public void setHogwartsStudent ( Boolean   hogwartsStudent ) { this.hogwartsStudent = hogwartsStudent ; }
    public void setActorName       ( String    actorName       ) { this.actorName       = actorName       ; }
    public void setAlive           ( Boolean   alive           ) { this.alive           = alive           ; }
    public void setAlternateActors ( String[]  alternateActors ) { this.alternateActors = alternateActors ; }
    public void setDateOfBirth     ( LocalDate dateOfBirth     ) { this.dateOfBirth     = dateOfBirth     ; }
    public void setYearOfBirth     ( int       yearOfBirth     ) { this.yearOfBirth     = yearOfBirth     ; }
    public void setEyeColour       ( String    eyeColour       ) { this.eyeColour       = eyeColour       ; }
    public void setGender          ( String    gender          ) { this.gender          = gender          ; }
    public void setHairColour      ( String    hairColour      ) { this.hairColour      = hairColour      ; }
    public void setWizard          ( Boolean   wizard          ) { this.wizard          = wizard          ; }
    
    public void set(String    id         , String  name         , String[] alternateNames , 
                    String    house      , String  ancestry     , String   species        , 
                    String    patronus   , Boolean hogwartsStaff, Boolean  hogwartsStudent, 
                    String    actorName  , Boolean alive        , String[] alternateActors,
                    LocalDate dateOfBirth, int     yearOfBirth  , String   eyeColour      , 
                    String    gender     , String  hairColour   , Boolean  wizard)
    {
        setId              ( id              );
        setName            ( name            );
        setAlternateNames  ( alternateNames  );
        setHouse           ( house           );
        setAncestry        ( ancestry        );
        setSpecies         ( species         );
        setPatronus        ( patronus        );
        setHogwartsStaff   ( hogwartsStaff   );
        setHogwartsStudent ( hogwartsStudent );
        setActorName       ( actorName       );
        setAlive           ( alive           );
        setAlternateActors ( alternateActors );
        setDateOfBirth     ( dateOfBirth     );
        setYearOfBirth     ( yearOfBirth     );
        setEyeColour       ( eyeColour       );
        setGender          ( gender          );
        setHairColour      ( hairColour      );
        setWizard          ( wizard          );
    } // end set ( )
    

    public String[] tratamentoArrayString ( String str ) 
    {  
        String [] array = null;
        if( str == null ) {
            array = null;
        }
        else
        {
            String tratada = "";
            for( int x = 0; x < str.length( ); x = x + 1 )
            {
                if( str.charAt(x) == '[' ) {
                    tratada = tratada + '{';
                } else if( str.charAt(x) == ']' ) {
                    tratada = tratada + '}';
                } else if ( str.charAt(x) == '\'' ) {
                    tratada = tratada + "";
                } else {
                    tratada = tratada + str.charAt(x);
                } // end if
            } // end for
            array = tratada.split( "," );
        } // end if
        return ( array );
    } // tratamentoArrayString ( )

    public LocalDate tratamentoDate ( String str ) 
    {        
        return ( LocalDate.parse( str, DateTimeFormatter.ofPattern("dd-M-yyyy") ) );
    } // end tratamentoDate ( )

    public Boolean tratamentoBool( String str )
    {
        if( str.equals("VERDADEIRO") || str.equals("true") || str.equals("1") )
            return ( true );
        else
            return ( false );
    } // tratamentoBool ( )

    public int tratamentoInt( String str ) {
        return ( Integer.parseInt( str ) );
    } // tratamentoInt ( )

    public String altNamesToString ( ) 
    {
        String result = "";
        if( alternateNames == null ) {
            result = "{}";
        }
        else
        {
            for( int x = 0; x < this.alternateNames.length; x++ )
            {
                if( x < this.alternateNames.length-1 ) {
                    result = result + this.alternateNames[x] + ",";
                }
                else {        
                    result = result + this.alternateNames[x];
                }
            } // end for
        } // end if
        return( result );
    } // end altNamesToString ( )

    public String dateBirthToString ( )
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = this.dateOfBirth.format(formatter);
        return ( date );
    } // end dateBirthToString ( )
    
    public static boolean isFim( String s )
    {
        boolean result = false;
        if( s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' )
        {
            result = true;
        } // end if
        return ( result );
    } // end isFim ( )
    @Override
    public String toString( ) 
    {
        String toString = "";
        toString =  getId         ( ) + " ## " + getName         ( ) + " ## " + altNamesToString  ( ) + " ## " + 
                    getHouse      ( ) + " ## " + getAncestry     ( ) + " ## " + getSpecies        ( ) + " ## " + 
                    getPatronus   ( ) + " ## " + getHogwartsStaff( ) + " ## " + getHogwartsStudent( ) + " ## " + 
                    getActorName  ( ) + " ## " + getAlive        ( ) + " ## " + dateBirthToString ( ) + " ## " + 
                    getYearOfBirth( ) + " ## " + getEyeColour    ( ) + " ## " + getGender         ( ) + " ## " + 
                    getHairColour ( ) + " ## " + getWizard       ( ); 
		return ( toString );
	} // end toString ( )
    public Personagem clone ( )
    {
        Personagem clone = new Personagem( );
        clone.setId             ( getId              ( ) );       
        clone.setName           ( getName            ( ) );         
        clone.setAlternateNames ( getAlternateNames  ( ) );  
        clone.setHouse          ( getHouse           ( ) );           
        clone.setAncestry       ( getAncestry        ( ) );        
        clone.setSpecies        ( getSpecies         ( ) );         
        clone.setPatronus       ( getPatronus        ( ) );        
        clone.setHogwartsStaff  ( getHogwartsStaff   ( ) );   
        clone.setHogwartsStudent( getHogwartsStudent ( ) );
        clone.setActorName      ( getActorName       ( ) );       
        clone.setAlive          ( getAlive           ( ) );           
        clone.setDateOfBirth    ( getDateOfBirth     ( ) );     
        clone.setYearOfBirth    ( getYearOfBirth     ( ) );     
        clone.setEyeColour      ( getEyeColour       ( ) );       
        clone.setGender         ( getGender          ( ) );          
        clone.setHairColour     ( getHairColour      ( ) );      
        clone.setWizard         ( getWizard          ( ) );
        return ( clone );
    } // clone ( )
    public void imprimir ( )
    {
        System.out.println( "[" + toString( ) + "]" );
    } // end imprimir ( )
    public Personagem ler ( String id )
    {
        Personagem perso = new Personagem( );
        String path = "/tmp/characters.csv";

        try 
        { 
            File file = new File( path );
            Scanner scan = new Scanner( file );
            
            scan.nextLine( ); // Ignorar o cabeçalho do arquivo
            
            boolean found = false;
            while( scan.hasNextLine() && !found )
            {
                String input = scan.nextLine( );
                if( id.equals( input.substring( 0, input.indexOf( ";" ) ) ) )
                {
                    found = true;
                    String [] atributos = input.split( ";" );
                    perso.set(  atributos[0], atributos[1], tratamentoArrayString(atributos[2]),
                                atributos[3], atributos[4], atributos[5], atributos[6],
                                tratamentoBool(atributos[7]), tratamentoBool(atributos[8]), atributos[9], 
                                tratamentoBool(atributos[10]), tratamentoArrayString(atributos[11]),
                                tratamentoDate(atributos[12]) , tratamentoInt(atributos[13]),
                                atributos[14],atributos[15], atributos[16], tratamentoBool(atributos[17])  );
                } // end if
            } // end while

            if( !found ) {
                System.out.println( "Character Not Found." );
            } // end if

            scan.close( );
        } // end try
        catch( FileNotFoundException e ) {
            System.out.println( "ERROR: File Not Found." );
        } // end catch
        return ( perso );
    } // end ler ( )

    public static void swap( Celula i, Celula j) 
    {
        Personagem temp = i.perso;
        i.perso = j.perso;
        j.perso = temp;
    } // end swap ( )

    public static boolean exist ( Celula i, Celula j )
    {
        boolean result = false;
        while( i != null && !result )
        {
            if( i == j ) {
                result = true;
            } // end if
            i = i.prox;
        } // end while
        return ( result );
    } // end exist ( )

    public static void quickSort( Celula esq, Celula dir) 
    {
        if( esq != dir && esq != dir.prox )
        {
            Celula i = esq, j = dir;
            String pivo = esq.perso.getHouse( );
            while( exist( i, j ) ) 
            {
                while ( i.perso.getHouse( ).compareTo( pivo ) < 0 ) 
                { 
                    i = i.prox; 
                } // end while
                while ( j.perso.getHouse( ).compareTo( pivo ) > 0 ) 
                { 
                    j = j.ant; 
                } // end while
                if( exist( i, j ) ) 
                { 
                    swap( i, j); 
                    i = i.prox; 
                    j = j.ant; 
                } // end if
            } // end while
            quickSort( esq, j);
            quickSort( i, dir);
        }
    } // end quickSort ( )

    public static void sortByName( Lista lista)
    {
        for( Celula i = lista.primeiro.prox; i != null; i = i.prox )
        {
            Celula menor = i;
            for( Celula j = i.prox; j != null; j = j.prox )
            {
                Personagem p1 = menor.perso;
                Personagem p2 = j.perso;
                int comparacaoCasa = p1.getHouse( ).compareTo( p2.getHouse( ) );
                if( comparacaoCasa == 0 ) 
                { // Casas são iguais, então compara os nomes
                    if( p1.getName( ).compareTo( p2.getName( ) ) > 0 ) 
                    {
                        menor = j;
                    } // end if
                } 
                else if( comparacaoCasa > 0 ) 
                { // p1 vem depois de p2
                    menor = j;
                } // end if
            } // end for
            swap( menor, i);
        } // end for
    } // end sortByName ( )

    public static void callQuick( Lista lista) 
    {
        quickSort( lista.primeiro.prox, lista.ultimo);
        sortByName( lista);
    } // end callQuick ( )
} // end class

public class ListaDuplaFlex extends Personagem
{
    public static void main ( String [] args )
    {
        Scanner scan = new Scanner( System.in );
        Personagem perso = new Personagem( );
        Lista lista = new Lista( );

        // fazer a leitura dos dados
        String input = scan.nextLine( );
        while( !isFim( input ) )
        {
            lista.inserirFim( perso.ler( input ) );
            input = scan.nextLine( );
        } // end while

        callQuick( lista );
        scan.close( );

        // imprimir os personagens
        lista.mostrar( );
    } // end main ( )

} // end class 
