package TP03.Q05;


import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;


class Celula
{
    Personagem elemento;
    Celula     prox;

    public Celula ( )
    {
        this( null );
    } 

    public Celula ( Personagem personagem )
    {
        this.elemento = personagem;
        this.prox = null;
    } 
}
class Lista
{
    private Celula primeiro;
    private Celula ultimo;

    public Lista ( )
    {
        primeiro = new Celula( );
        ultimo = primeiro;
    } // end Lista ( )

    public void inserirFim ( Personagem personagem ) throws Exception
    {
        ultimo.prox = new Celula( personagem );
        ultimo = ultimo.prox;
    } // end inserirFim ( )

    public void inserirInicio ( Personagem personagem ) throws Exception
    {
        Celula temp = new Celula( personagem );
        temp.prox = primeiro.prox;
		primeiro.prox = temp;
		if( primeiro == ultimo ) {                 
			ultimo = temp;
		} 
        temp = null;
    } // end inserirInicio ( )

    public Personagem removerFim ( ) throws Exception
    {
        if( primeiro == ultimo ) {
			throw new Exception( "Erro ao remover (vazia)!" );
		} 

		// Caminhar ate a penultima celula:
        Celula i;
        for( i = primeiro; i.prox != ultimo; i = i.prox );

        Personagem perso = ultimo.elemento; 
        ultimo = i; 
        i = ultimo.prox = null;
        
		return ( perso );
    } // end removerFim ( )

    public Personagem removerInicio ( ) throws Exception
    {
        if( primeiro == ultimo ) {
			throw new Exception( "Erro ao remover (vazia)!" );
		} 

        Celula temp = primeiro;
		primeiro = primeiro.prox;
		Personagem perso = primeiro.elemento;
        temp.prox = null;
        temp = null;
		return ( perso );
    } // end removerInicio ( )

    public void inserir ( Personagem personagem, int index ) throws Exception
    {
        int tamanho = tamanho( );

        if( index < 0 || index > tamanho ) {
            throw new Exception( "Erro ao inserir posicao (" + index + " / tamanho = " + tamanho + ") invalida!" );
        } else if( index == 0 ) {
            inserirInicio( personagem );
        } else if( index == tamanho ) {
            inserirFim( personagem );
        } 
        else 
        {
	    	// Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for( int j = 0; j < index; j++, i = i.prox );
        
            Celula temp = new Celula( personagem );
            temp.prox = i.prox;
            i.prox = temp;
            temp = i = null;
        } 
    } // end inserir ( )

    public Personagem remover ( int index ) throws Exception
    {
        Personagem perso = null;
        int tamanho = tamanho( );

        if( primeiro == ultimo ) {
            throw new Exception( "Erro ao remover (vazia)!" );
        } else if( index < 0 || index >= tamanho ) {
            throw new Exception( "Erro ao remover (posicao " + index + " / " + tamanho + " invalida!" );
        } else if( index == 0 ) {
            perso = removerInicio( );
        } else if( index == tamanho - 1 ) {
            perso = removerFim( );
        } 
        else 
        {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for( int j = 0; j < index; j++, i = i.prox );
            
            Celula temp = i.prox;
            perso = temp.elemento;
            i.prox = temp.prox;
            temp.prox = null;
            i = temp = null;
        } 

		return ( perso );
    } // end remover ( )

    public int tamanho ( ) 
    {
        int length = 0; 
        for( Celula i = primeiro; i != ultimo; i = i.prox, length++ );
        return ( length );
    } // end length ( )

    public void mostrar ( )
    {   
        int j = 0;
        for( Celula i = primeiro.prox; i != null; i = i.prox, j = j + 1 )
        {
            i.elemento.imprimir( j );
        } 
    } 

} 
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
    } 
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
    }

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
    }
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
                } 
            } 
            array = tratada.split( "," );
        } 
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
            } 
        } 
        return( result );
    } // end altNamesToString ( )

    public String dateBirthToString ( )
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = this.dateOfBirth.format(formatter);
        return ( date );
    } 
    public static boolean isFim( String s )
    {
        boolean result = false;
        if( s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M' )
        {
            result = true;
        } 
        return ( result );
    }
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
	} 
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
    } 
    public void imprimir ( )
    {
        System.out.println( "[" + toString( ) + "]" );
    } 
    public void imprimir ( int x )
    {
        System.out.println( "[" + x + " ## " + toString( ) + "]" );
    } 
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
                } 
            } 

            if( !found ) {
                System.out.println( "Character Not Found." );
            } 

            scan.close( );
        } 
        catch( FileNotFoundException e ) {
            System.out.println( "ERROR: File Not Found." );
        }
        return ( perso );
    } 
}
public class ListaFlex extends Personagem
{
    public static void main ( String [] args ) throws Exception
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
        } 
        int tam = scan.nextInt( );
        for( int i = 0; i <= tam; i = i + 1 ) 
        {
            input = scan.nextLine( );
            String[] str = input.split( " " );
            Personagem outro;
            try 
            {
                switch( str[0] ) 
                {
                    case "II":
                        outro = perso.ler( str[1] );
                        lista.inserirInicio( outro );
                        break;
                    case "IF":
                        outro = perso.ler( str[1] );
                        lista.inserirFim( outro );
                        break;
                    case "I*":
                        outro = perso.ler( str[2] );
                        lista.inserir( outro, Integer.parseInt(str[1]) );
                        break;
                    case "RI":
                        outro = lista.removerInicio( );
                        System.out.println( "(R) " + outro.getName( ) );
                        break;
                    case "RF":
                        outro = lista.removerFim( );
                        System.out.println( "(R) " + outro.getName( ) );
                        break;
                    case "R*":
                        outro = lista.remover( Integer.parseInt( str[1] ) );
                        System.out.println( "(R) " + outro.getName( ) );
                        break;
                    default:
                        break;
                } // end switch 
            } catch( Exception e ) {
                e.getMessage();
            }
        } 
        lista.mostrar( );
        scan.close( );
    } // end main ( )
} 
