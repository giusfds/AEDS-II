
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#include <wchar.h>   
#include <locale.h>


typedef struct s_Personagem
{
    char*   id              ; 
    char*   name            ; 
    char*   alternateNames  ;
    char*   house           ; 
    char*   ancestry        ; 
    char*   species         ; 
    char*   patronus        ; 
    bool    hogwartsStaff   ;  
    bool    hogwartsStudent ;  
    char*   actorName       ; 
    bool    alive           ;
    char*   alternateActors ; 
    char*   dateOfBirth     ; 
    int     yearOfBirth     ; 
    char*   eyeColour       ; 
    char*   gender          ; 
    char*   hairColour      ; 
    bool    wizard          ; 
} Personagem;


bool exist_Personagem( Personagem *perso )
{
    bool exist = false;
    if( perso != NULL && 
        perso->id != NULL && perso->name != NULL && perso->alternateNames != NULL && perso->house != NULL &&
        perso->ancestry != NULL && perso->species != NULL && perso->patronus != NULL && perso->actorName != NULL &&
        perso->alternateActors != NULL && perso->dateOfBirth != NULL && perso->eyeColour != NULL && 
        perso->gender != NULL && perso->hairColour != NULL )
    {
        exist = true;
    } // end if
    return ( exist );
} // end exist_Personagem ( )

Personagem* new_Personagem( void )
{
    Personagem *perso = (Personagem*) malloc ( 1 * sizeof(Personagem) );
    if( perso != NULL )
    {
        perso->id              = (char*) calloc (  50, sizeof(char) );
        perso->name            = (char*) calloc (  50, sizeof(char) );
        perso->alternateNames  = (char*) calloc ( 300, sizeof(char) );
        perso->house           = (char*) calloc (  50, sizeof(char) );
        perso->ancestry        = (char*) calloc (  50, sizeof(char) );
        perso->species         = (char*) calloc (  50, sizeof(char) );
        perso->patronus        = (char*) calloc (  50, sizeof(char) );
        perso->hogwartsStaff   = false                               ; 
        perso->hogwartsStudent = false                               ; 
        perso->actorName       = (char*) calloc (  50, sizeof(char) );
        perso->alive           = false                               ; 
        perso->alternateActors = (char*) calloc ( 255, sizeof(char) );
        perso->dateOfBirth     = (char*) calloc (  50, sizeof(char) );
        perso->yearOfBirth     = -1                                  ; 
        perso->eyeColour       = (char*) calloc (  50, sizeof(char) );
        perso->gender          = (char*) calloc (  50, sizeof(char) );
        perso->hairColour      = (char*) calloc (  50, sizeof(char) );
        perso->wizard          = false                               ; 

        if( !exist_Personagem( perso ) )
        {
            printf( "\n%s\n", "ERROR: Unable to alloc memory for \'Personagem\'." );
        } // end if
    } // end if
    return ( perso );
} // end new_Personagem ( )

void delete_Personagem( Personagem *perso )
{
    if( perso != NULL )
    {
        if( exist_Personagem( perso ) ) 
        {
            free( perso->id              ); perso->id              = NULL;
            free( perso->name            ); perso->name            = NULL;
            free( perso->alternateNames  ); perso->alternateNames  = NULL;
            free( perso->house           ); perso->house           = NULL;
            free( perso->ancestry        ); perso->ancestry        = NULL;
            free( perso->species         ); perso->species         = NULL;
            free( perso->patronus        ); perso->patronus        = NULL;
            free( perso->actorName       ); perso->actorName       = NULL;
            free( perso->alternateActors ); perso->alternateActors = NULL;
            free( perso->dateOfBirth     ); perso->dateOfBirth     = NULL;
            free( perso->eyeColour       ); perso->eyeColour       = NULL;
        }
        free( perso ); perso = NULL;  
    } // end if
} // end delete_Personagem ( )


char* getId              ( Personagem *perso ) { return ( perso->id              ); }
char* getName            ( Personagem *perso ) { return ( perso->name            ); }
char* getAlternateNames  ( Personagem *perso ) { return ( perso->alternateNames  ); }
char* getHouse           ( Personagem *perso ) { return ( perso->house           ); }
char* getAncestry        ( Personagem *perso ) { return ( perso->ancestry        ); }
char* getSpecies         ( Personagem *perso ) { return ( perso->species         ); }
char* getPatronus        ( Personagem *perso ) { return ( perso->patronus        ); }
bool  getHogwartsStaff   ( Personagem *perso ) { return ( perso->hogwartsStaff   ); }
bool  getHogwartsStudent ( Personagem *perso ) { return ( perso->hogwartsStudent ); }
char* getActorName       ( Personagem *perso ) { return ( perso->actorName       ); }
bool  getAlive           ( Personagem *perso ) { return ( perso->alive           ); }
char* getAlternateActors ( Personagem *perso ) { return ( perso->alternateActors ); }
char* getDateOfBirth     ( Personagem *perso ) { return ( perso->dateOfBirth     ); }
int   getYearOfBirth     ( Personagem *perso ) { return ( perso->yearOfBirth     ); }
char* getEyeColour       ( Personagem *perso ) { return ( perso->eyeColour       ); }
char* getGender          ( Personagem *perso ) { return ( perso->gender          ); }
char* getHairColour      ( Personagem *perso ) { return ( perso->hairColour      ); }
bool  getWizard          ( Personagem *perso ) { return ( perso->wizard          ); }


void setId              ( Personagem *perso, char* id              ) { strcpy( perso->id              , id             ) ; }
void setName            ( Personagem *perso, char* name            ) { strcpy( perso->name            , name           ) ; }
void setAlternateNames  ( Personagem *perso, char* alternateNames  ) { strcpy( perso->alternateNames  , alternateNames ) ; } 
void setHouse           ( Personagem *perso, char* house           ) { strcpy( perso->house           , house          ) ; }
void setAncestry        ( Personagem *perso, char* ancestry        ) { strcpy( perso->ancestry        , ancestry       ) ; }
void setSpecies         ( Personagem *perso, char* species         ) { strcpy( perso->species         , species        ) ; }
void setPatronus        ( Personagem *perso, char* patronus        ) { strcpy( perso->patronus        , patronus       ) ; }
void setHogwartsStaff   ( Personagem *perso, bool  hogwartsStaff   ) {         perso->hogwartsStaff   = hogwartsStaff    ; }
void setHogwartsStudent ( Personagem *perso, bool  hogwartsStudent ) {         perso->hogwartsStudent = hogwartsStudent  ; }
void setActorName       ( Personagem *perso, char* actorName       ) { strcpy( perso->actorName       , actorName      ) ; }
void setAlive           ( Personagem *perso, bool  alive           ) {         perso->alive           = alive            ; }
void setAlternateActors ( Personagem *perso, char* alternateActors ) { strcpy( perso->alternateActors , alternateActors) ; }
void setDateOfBirth     ( Personagem *perso, char* dateOfBirth     ) { strcpy( perso->dateOfBirth     , dateOfBirth    ) ; }
void setYearOfBirth     ( Personagem *perso, int   yearOfBirth     ) {         perso->yearOfBirth     = yearOfBirth      ; }
void setEyeColour       ( Personagem *perso, char* eyeColour       ) { strcpy( perso->eyeColour       , eyeColour      ) ; }
void setGender          ( Personagem *perso, char* gender          ) { strcpy( perso->gender          , gender         ) ; }
void setHairColour      ( Personagem *perso, char* hairColour      ) { strcpy( perso->hairColour      , hairColour     ) ; }
void setWizard          ( Personagem *perso, bool  wizard          ) {         perso->wizard          = wizard           ; }


void init_Personagem ( Personagem *perso,
                        char* id             , char* name       , char* alternateNames , char* house          , 
                        char* ancestry       , char* species    , char* patronus       , bool  hogwartsStaff  ,
                        bool  hogwartsStudent, char* actorName  , bool  alive          , char* alternateActors, 
                        char* dateOfBirth    , int   yearOfBirth, char* eyeColour      , char* gender         , 
                        char* hairColour     , bool wizard )
{
    if( exist_Personagem( perso ) ) 
    {
        setId              ( perso, id              );
        setName            ( perso, name            );
        setAlternateNames  ( perso, alternateNames  );
        setHouse           ( perso, house           );
        setAncestry        ( perso, ancestry        );
        setSpecies         ( perso, species         );
        setPatronus        ( perso, patronus        );
        setHogwartsStaff   ( perso, hogwartsStaff   );
        setHogwartsStudent ( perso, hogwartsStudent );
        setActorName       ( perso, actorName       );
        setAlive           ( perso, alive           );
        setAlternateActors ( perso, alternateActors );
        setDateOfBirth     ( perso, dateOfBirth     );
        setYearOfBirth     ( perso, yearOfBirth     );
        setEyeColour       ( perso, eyeColour       );
        setGender          ( perso, gender          );
        setHairColour      ( perso, hairColour      );
        setWizard          ( perso, wizard          );
    }
    else {
        printf( "\n%s\n", "ERROR: Unable to inicialize the \'Personagem\'." );
    } // end if
} // end init_Personagem ( )


Personagem* clone( Personagem *perso )
{
    Personagem *copy = new_Personagem( );
    if( exist_Personagem ( perso ) && exist_Personagem( copy ) )
    {
        init_Personagem(copy,
                        getId              ( perso ),
                        getName            ( perso ),
                        getAlternateNames  ( perso ),
                        getHouse           ( perso ),
                        getAncestry        ( perso ),
                        getSpecies         ( perso ),
                        getPatronus        ( perso ),
                        getHogwartsStaff   ( perso ),
                        getHogwartsStudent ( perso ),
                        getActorName       ( perso ),
                        getAlive           ( perso ),
                        getAlternateActors ( perso ),
                        getDateOfBirth     ( perso ),
                        getYearOfBirth     ( perso ),
                        getEyeColour       ( perso ),
                        getGender          ( perso ),
                        getHairColour      ( perso ),
                        getWizard          ( perso )  );
    } 
    else {
        printf( "\n%s\n", "ERROR: Unable to clone the \'Personagem\'." );    
    }// end if
    return ( copy );
} // end clone ( )

void imprimir ( Personagem *perso )
{
    printf( "[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
            getId              ( perso ),
            getName            ( perso ),
            getAlternateNames  ( perso ),
            getHouse           ( perso ),
            getAncestry        ( perso ),
            getSpecies         ( perso ),
            getPatronus        ( perso ),
            getHogwartsStaff   ( perso ) ? "true" : "false",
            getHogwartsStudent ( perso ) ? "true" : "false",
            getActorName       ( perso ),
            getAlive           ( perso ) ? "true" : "false",
            getDateOfBirth     ( perso ),
            getYearOfBirth     ( perso ),
            getEyeColour       ( perso ),
            getGender          ( perso ),
            getHairColour      ( perso ),
            getWizard          ( perso ) ? "true" : "false" ); 
} // end imprimir ( )


void imprimir2 ( int id, Personagem *perso )
{
    printf( "[%d ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
            id                          ,
            getId              ( perso ),
            getName            ( perso ),
            getAlternateNames  ( perso ),
            getHouse           ( perso ),
            getAncestry        ( perso ),
            getSpecies         ( perso ),
            getPatronus        ( perso ),
            getHogwartsStaff   ( perso ) ? "true" : "false",
            getHogwartsStudent ( perso ) ? "true" : "false",
            getActorName       ( perso ),
            getAlive           ( perso ) ? "true" : "false",
            getDateOfBirth     ( perso ),
            getYearOfBirth     ( perso ),
            getEyeColour       ( perso ),
            getGender          ( perso ),
            getHairColour      ( perso ),
            getWizard          ( perso ) ? "true" : "false" ); 
} // end imprimir ( )


char* tratamentoBool( char* strbool )
{
    char* tratada = strbool;
    tratada[strcspn(tratada,"\n")] = '\0';
    tratada[strcspn(tratada,"\r")] = '\0';
    return ( tratada );
} // end tratamentoBool ( )

char* tratamentoData( char* dateOfBirth )
{
    char *tratada = dateOfBirth;
    int len = strlen( dateOfBirth );
    if( len < 10 )
    {
        tratada = (char*) calloc ( 11, sizeof(char) );
        strcpy( tratada, dateOfBirth );
        for( int x = len; x > 3; x = x - 1 )
        {
            tratada[x] = tratada[x-1];
        }
        tratada[3] = '0';
    } // end if
    return ( tratada );
} // end tratamentoData ( )

Personagem* ler( char* filename, char* id_procurado ) 
{
    Personagem *perso = new_Personagem( );
    FILE* file = fopen( filename, "rt" );

    if( file == NULL || !exist_Personagem( perso ) ) {
        printf( "\n%s\n", "ERROR: Unable to read.");
    }
    else
    {
        char line[500];
        bool idFound = false;

        // Ignora a linha de cabeçalho
        fgets( line, sizeof(line), file );
        // Lê as demais linhas do arquivo
        while( fgets( line, sizeof(line), file ) != NULL && !idFound ) 
        {
            char* token = strtok( line, ";" );
            char *atributos[18];
            int index = 0;
            while( token != NULL ) 
            {
                atributos[index++] = strdup( token );
                token = strtok( NULL, ";" );
            } // end while

            // Tratamento do atributo 'alternateNames'
            char temp[500] = {0};
            int pos = 0;
            int len = strlen( atributos[2] );
            for( int x = 0; x < len; x = x + 1 ) 
            {
                if( atributos[2][x] == '[' ) {
                    temp[pos] = '{';
                } else if( atributos[2][x] == ']' ) {
                    temp[pos] = '}';
                } else if( atributos[2][x] == '\'' ) {
                    continue; 
                } else {
                    temp[pos] = atributos[2][x];
                }
                pos++; 
            }
            temp[pos] = '\0'; 
            // Desalocar o atributo 'alternateNames' e atribuir a string tratada
            free( atributos[2] ) ; atributos[2] = strdup(temp);

            // Verificar se os atributos são iguais
            if( strcmp(atributos[0], id_procurado) == 0 ) 
            {
                idFound = true;
                // inicializar o Personagem com os dados lidos
                if( index < 18 )
                {
                    if( index > 16 ) 
                    {
                        init_Personagem(perso,
                                        atributos[0], atributos[1], atributos[2], atributos[3],
                                        atributos[4], atributos[5], "" ,
                                 strcmp(atributos[6], "VERDADEIRO") == 0,
                                 strcmp(atributos[7], "VERDADEIRO") == 0,
                                        atributos[8], 
                                 strcmp(atributos[9], "VERDADEIRO") == 0,
                                        atributos[10], 
                         tratamentoData(atributos[11]),
                                   atoi(atributos[12]), 
                                        atributos[13], atributos[14],atributos[15], 
                                 strcmp(tratamentoBool(atributos[16]), "VERDADEIRO") == 0 );
                    } 
                    else
                    {
                        init_Personagem(perso,
                                        atributos[0], atributos[1], atributos[2], atributos[3],
                                        atributos[4], atributos[5], "" ,
                                 strcmp(atributos[6], "VERDADEIRO") == 0,
                                 strcmp(atributos[7], "VERDADEIRO") == 0, "", 
                                 strcmp(atributos[8], "VERDADEIRO") == 0,
                                        atributos[9],
                         tratamentoData(atributos[10]),
                                   atoi(atributos[11]), atributos[12], 
                                        atributos[13],atributos[14], 
                                 strcmp(tratamentoBool(atributos[15]), "VERDADEIRO") == 0 );
                    } // end if
                }
                else
                {
                    init_Personagem(perso,
                                    atributos[0], atributos[1], atributos[2], atributos[3],
                                    atributos[4], atributos[5], atributos[6],
                             strcmp(atributos[7], "VERDADEIRO") == 0,
                             strcmp(atributos[8], "VERDADEIRO") == 0,
                                    atributos[9], 
                             strcmp(atributos[10], "VERDADEIRO") == 0,
                                    atributos[11], 
                     tratamentoData(atributos[12]),
                               atoi(atributos[13]), 
                                    atributos[14], atributos[15],
                                    atributos[16], 
                             strcmp(tratamentoBool(atributos[17]), "VERDADEIRO") == 0 );
                } // end if
            } // end if
            // Libera memória alocada para atributos
            for (int x = 0; x < index; x++) {
                free(atributos[x]);
            } // end for
        } // end while 
        fclose(file);
    } // end if
    return ( perso );
} // end ler ( )

typedef struct s_Celula
{
    Personagem* perso;
    struct s_Celula* prox;
} Celula;

Celula* new_Celula ( Personagem* personagem )
{
    Celula* nova = (Celula*) malloc( sizeof(Celula) );
    if( nova != NULL )
    {
        nova->perso = personagem;
        nova->prox = NULL;
    } // end if
    return ( nova );
} // end new_Celula ( )

typedef struct s_Fila
{
    Celula* primeiro;
    Celula* ultimo;
    int tamanho;
    int MAXTAM;
} Fila;

Fila* new_Fila (  )
{
    Fila* fila = (Fila*) malloc( sizeof(Fila) );
    if( fila != NULL )
    {
        fila->primeiro = new_Celula( NULL );
        fila->ultimo = fila->primeiro;
        fila->tamanho = 0;
        fila->MAXTAM = 5;
    } // end if
    return( fila );
} // end new_Fila ( )

void delete_Fila ( Fila* fila )
{
    if( fila != NULL )
    {
        Celula* atual = fila->primeiro;
        while( atual != NULL )
        {
            Celula* prox = atual->prox;
            delete_Personagem( atual->perso );
            free( atual );
            atual = prox;
        } // end while
        fila->primeiro = fila->ultimo = NULL;
        free( fila ); fila = NULL;
    } // end if
} // end delete_Fila ( )

int media( Fila* fila )
{
    int media = 0;
    int soma = 0;
    for( Celula* i = fila->primeiro->prox; i != NULL; i = i->prox ) {
        soma = soma + getYearOfBirth( i->perso );
    } // end for
    media = soma / fila->tamanho;
    return ( media );
} // end media ( )

Personagem* remover ( Fila* fila ) 
{
    if( fila->primeiro == fila->ultimo ) {
        printf( "\n%s\n", "ERRO: Fila Vazia!" );
        exit( 1 );
    } // end if
    Celula* temp = fila->primeiro->prox;
    Personagem* perso = temp->perso;
    fila->primeiro->prox = temp->prox;
    if( temp == fila->ultimo ) {
        fila->ultimo = fila->primeiro;
    } // end if
    temp->prox = NULL;
    free( temp );
    fila->tamanho--;
    return ( perso );
} // end remover ( )

void inserir ( Fila* fila, Personagem* perso )
{
    if( fila->tamanho == fila->MAXTAM )
    {
        Personagem* perso = remover ( fila );
    }
    fila->ultimo->prox = new_Celula( perso );
    fila->ultimo = fila->ultimo->prox;
    fila->tamanho++;
    printf( ">> Year Birthday Average: %d\n", media( fila ) );
} // end inserir ( )

void mostrar ( Fila* fila )
{
    printf( "%s\n", "[ Head ]" );
    int j = 0;
    for( Celula* i = fila->primeiro->prox; i != NULL;  i = i->prox, j = j + 1 )
    {
        imprimir2( j, i->perso );
    } // end for ( )
    printf( "%s\n", "[ Tail ]" );
} // end mostrar ( )

/**
 *  Função Principal.
*/
int main ( void )
{
    setlocale( LC_CTYPE, "UTF-8" ); // setCharset

    Fila* fila = new_Fila( 405 );
    Personagem* perso = NULL;

    char id [81] = { '\0' };
    char* filename = "/tmp/characters.csv";
    int numOp = 0;
    
    scanf( "%s", id ); getchar( );
    while( strcmp( id,"FIM" ) != 0 )
    {
        inserir( fila, ler( filename, id ) );
        scanf( "%80s", id ); getchar( );
    } // end while

    // fazer a leitura dos metodos
    scanf( "%d", &numOp ); getchar( );
    for ( int i = 0; i < numOp; i = i + 1 ) 
    {
        char input[81];
        scanf( "%s", input );

        if( strcmp(input, "I") == 0 ) 
        {
            scanf( "%s", id );
            perso = ler( filename, id );
            inserir( fila, perso );
        }
        else if( strcmp(input, "R") == 0 ) 
        {
            perso = remover( fila );
            printf( "(R) %s\n", getName( perso ) );
        } // end if
    } // end for
    mostrar( fila );

    delete_Fila( fila );
    
    return ( 0 );
} // end main ( )
