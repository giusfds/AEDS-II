#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#include <wchar.h>   
#include <locale.h>

// ---------------------------------- Struct Pesonagem

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

// ---------------------------------- Struct Timer

typedef struct s_Timer
{
    clock_t startTime;
    clock_t endTime  ;
    double  totalTime;
} Timer;

// ---------------------------------- Struct Log

typedef struct s_Log
{
    int comparacoes;
    int movimentacoes;
} Log;

// ---------------------------------- Struct Celula

typedef struct s_Celula
{
    Personagem* elemento;
    struct s_Celula* prox;
} Celula;

// ---------------------------------- Struct Lista

typedef struct s_Lista
{
    Celula* primeiro;
    Celula* ultimo;
    int tamanho;
} Lista;

// ---------------------------------- Struct Lista

typedef struct s_Hash
{
    Lista** tabela;
    int tamanho;
} Hash;

// ---------------------------------- Funções - Personagem

/**
 *  Verificar existencia de espaço para o Personagem.
*/
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

/**
 *  Alocar o espaço de memória para o Personagem.
*/
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

/**
 *  Desalocar o espaço de momória do personagem.
*/
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

/**
 *  Funções GET.
*/
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

/**
 *  Funções SET.
*/
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

/**
 *  Função para inicializar um Personagem com valores.
*/
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

/**
 *  Função para clonar um Personagem.
*/
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

/**
 *  Função para imprimir um Personagem.
*/
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

/**
 *  Função para imprimir um Personagem.
*/
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

/**
 *  Função para tratamento das cadeia de caracteres "booleana"
*/
char* tratamentoBool( char* strbool )
{
    char* tratada = strbool;
    tratada[strcspn(tratada,"\n")] = '\0';
    tratada[strcspn(tratada,"\r")] = '\0';
    return ( tratada );
} // end tratamentoBool ( )

/**
 *  Função para tratamento da formatação da Data.
*/
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

/**
 *  Função para ler os personagens de um arquivo.
*/
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

// ---------------------------------- Funções - Timer

Timer new_Timer( void )
{
    Timer timer;
    timer.startTime = 0;
    timer.endTime   = 0;
    timer.totalTime = 0;
    return ( timer );
} // end new_Timer ( )

void start_Timer( Timer* time ) {
    time->startTime = clock( );
} // end startTime ( )

void end_Timer( Timer* time ) {
    time->endTime = clock( );
} // end endTime ( )

double total_Timer( Timer* time ) {
    time->totalTime = difftime( time->endTime, time->startTime ) / CLOCKS_PER_SEC;
    return ( time->totalTime );
} // end timeTotal ( )

// ---------------------------------- Funções - Log

Log new_Log( void )
{
    Log log;
    log.movimentacoes = 0;
    log.comparacoes = 0;
    return ( log ); 
} // end new_Log ( )

void registro( char* filename, Timer* time, Log* log )
{
    FILE *file = fopen( filename, "wt" );
    fprintf( file, "801779\tComparacoes: %d\t\tMovimentacoes: %d\tTempo de Execucao(ms): %lf\n",
                        log->comparacoes, log->movimentacoes, total_Timer( time ) );
    fclose( file );
} // end registro ( )

// ---------------------------------- Funções - Celula

Celula* new_Celula ( Personagem* personagem )
{
    Celula* nova = (Celula*) malloc ( sizeof(Celula) );
    if( nova != NULL )
    {
        nova->elemento = personagem;
        nova->prox = NULL;
    } // end if
    return ( nova );
} // end new_Celula ( )

// ---------------------------------- Funções - Lista

Lista* new_Lista ( void )
{
    Lista* nova = (Lista*) malloc ( sizeof(Lista) );
    if( nova != NULL )
    {
        nova->primeiro = nova->ultimo = new_Celula( NULL );
        nova->tamanho = 0;
    } // end if
    return ( nova );
} // end new_Lista ( )

void delete_Lista ( Lista* lista )
{
    if( lista != NULL )
    {
        for( Celula* i = lista->primeiro->prox; i != NULL; i = i->prox )
        {
            delete_Personagem( i->elemento );
        } // end for
        free( lista ); lista = NULL;
    } // end if
} // end delete_Lista ( )

void inserir_inicio_Lista ( Lista* lista, Personagem* perso )
{
    Celula* tmp = new_Celula( NULL );
    tmp->prox = lista->primeiro->prox;
    lista->primeiro->prox = tmp;
    if( lista->primeiro == lista->ultimo ) {                    
        lista->ultimo = tmp;
    } // end if
    tmp = NULL;
    lista->tamanho++;
} // end inserir_inicio_Lista ( )

void inserir_fim_Lista ( Lista* lista, Personagem* perso )
{
    lista->ultimo->prox = new_Celula( perso );
    lista->ultimo = lista->ultimo->prox;
    lista->tamanho++;
} // end inserir_fim_Lista

Personagem* remover_inicio_Lista ( Lista* lista )
{
    if( lista->primeiro == lista->ultimo ) {
        errx(1, "Erro ao remover!");
    } // end if
    Celula* tmp = lista->primeiro;
    lista->primeiro = lista->primeiro->prox;
    Personagem* resp = lista->primeiro->elemento;
    tmp->prox = NULL;
    free(tmp);
    tmp = NULL;
    lista->tamanho--;
    return ( resp );
} // end remover_inicio_Lista ( )

Personagem* remover_fim_Lista ( Lista* lista )
{
    if( lista->primeiro == lista->ultimo ) {
        errx(1, "Erro ao remover!");
    } // end if
    Celula* i = NULL;
    for( i = lista->primeiro; i->prox != lista->ultimo; i = i->prox );
    int resp = lista->ultimo->elemento;
    lista->ultimo = i;
    free(lista->ultimo->prox);
    i = lista->ultimo->prox = NULL;
    lista->tamanho--;
    return ( resp );
} // end remover_fim_Lista ( )

void inserir_Lista ( Lista* lista, Personagem* perso, int index )
{
    int tam = lista->tamanho;
    if( index < 0 || index > tam ) {
        errx(1, "Erro ao inserir posicao (%d/ tamanho = %d) invalida!", index, tam);
    } else if (index == 0) {
        inserir_inicio_Lista( lista, perso );
    } else if (index == tam){
        inserir_fim_Lista( lista, perso );
    } else {
        int j = 0;
        Celula* i = lista->primeiro;
        for( j = 0; j < index; j = j + 1, i = i->prox );  
        Celula* tmp = new_Celula( perso );
        tmp->prox = i->prox;
        i->prox = tmp;
        tmp = i = NULL;
    } // end if
} // end inserir_Lista ( )

Personagem* remover_Lista ( Lista* lista, int index )
{
    Personagem* resp = NULL;
    int tam = lista->tamanho;
    if ( lista->primeiro == lista->ultimo ) {
        errx(1, "Erro ao remover (vazia)!");
    } else if ( index < 0 || index >= tam ) {
        errx(1, "Erro ao remover posicao (%d/ tamanho = %d) invalida!", index, tam);
    } else if ( index == 0 ) {
        resp = removerInicio();
    } else if ( index == tam - 1 ) {
        resp = removerFim( );
    } else {
        Celula* i = lista->primeiro;
        int j = 0;
        for( j = 0; j < index; j++, i = i->prox );      
        Celula* tmp = i->prox;
        resp = tmp->elemento;
        i->prox = tmp->prox;
        tmp->prox = NULL;
        free(tmp);
        i = tmp = NULL;
    } // end if
    return ( resp );
} // end remover_Lista ( )

bool pesquisar_Lista ( Lista* lista, Personagem* perso )
{
    bool result = false;
    for( Celula* i = lista->primeiro->prox; i != NULL; i = i->prox )
    {
        if( strcmp( getName(i->elemento), getName(perso) ) == 0 )
        {
            result = true;
            i = NULL;
        } // end if
    } // end for
    return ( result );
} // end pesquisar_Lista ( )

// ---------------------------------- Funções - Hash

Hash* new_Hash ( int tamanho )
{
    Hash* nova = (Hash*) malloc ( sizeof(Hash) );
    if( nova != NULL && tamanho > 0 )
    {
        nova->tamanho = tamanho;
        for( int i = 0; i < nova->tamanho; i = i + 1 ) {
            nova->tabela[i] = new_Lista( );
        } // end for
    } // end if
    return ( nova );
} // end new_Hash ( )

int h_Hash ( Hash* hash, Personagem* perso )
{
    return ( getYearOfBirth( perso ) % hash->tamanho );
} // end h ( )

bool pesquisar_Hash ( Hash* hash , Personagem* perso, Log* log )
{
    int pos = h( hash, perso );
    return ( pesquisar_Lista(hash->tabela[pos], perso) );
} // end pesquisar_Hash ( )

bool inserir_Hash ( Hash* hash , Personagem* perso )
{
    int pos = h( hash, perso );
    inserir_fim_Lista(hash->tabela[pos], perso);
} // end pesquisar ( )

// ---------------------------------- Main

void readLine ( char* buffer, int length ) 
{
    if( fgets( buffer, length, stdin ) != NULL ) 
    {
        buffer[strcspn(buffer, "\n")] = '\0'; // Remove '\n'
        buffer[strcspn(buffer, "\r")] = '\0'; // Remove '\r'
    } // end if
} // end readLine ( )

/**
 *  Função Principal.
*/
int main ( void )
{
    setlocale( LC_CTYPE, "UTF-8" ); // setCharset

    Hash* hash  = new_Hash  ( 25 );
    Timer timer = new_Timer ( );
    Log   log   = new_Log   ( );

    char id  [81] = { '\0' };
    char nome[81] = { '\0' };
    char* filename = "/tmp/characters.csv";

    readLine( id, 81 );
    while( strcmp( id,"FIM" ) != 0 )
    {
        inserir( hash, ler( filename, id ) );
        readLine( id, 81 );
    } // end while

    start_Timer( &timer );
    readLine( nome, 81 );
    while ( strcmp( nome, "FIM" ) != 0 )
    {
        bool resp = pesquisar_Hash( hash, nome, &log );
        if( resp == true ) {
            printf( "%s\n", "SIM" );
        }
        else {
            printf( "%s\n", "NAO" );
        } // end if
        readLine( nome, 81 );
    } // end while
    end_Timer( &timer );
    registro( "801779_hashIndireta.txt", &timer, &log );
    
    delete_AVL( hash );

    return ( 0 );
} // end main ( )