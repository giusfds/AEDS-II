#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <wchar.h>   
#include <locale.h>

#define bool   short
#define true   1
#define false  0

typedef struct CelulaDupla {
	int elemento;
	struct CelulaDupla* prox;
    struct CelulaDupla* ant;  
} CelulaDupla;

CelulaDupla* novaCelulaDupla(int elemento) {
    CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
    nova->elemento = elemento;
    nova->ant = nova->prox = NULL;
    return nova;
}

CelulaDupla* primeiro;
CelulaDupla* ultimo;


void start () {
    primeiro = novaCelulaDupla(-1);
    ultimo = primeiro;
}


void inserirInicio(int x) {
    CelulaDupla* tmp = novaCelulaDupla(x);

    tmp->ant = primeiro;
    tmp->prox = primeiro->prox;
    primeiro->prox = tmp;
    if (primeiro == ultimo) {                    
        ultimo = tmp;
    } else {
        tmp->prox->ant = tmp;
    }
    tmp = NULL;
}


void inserirFim(int x) {
    ultimo->prox = novaCelulaDupla(x);
    ultimo->prox->ant = ultimo;
    ultimo = ultimo->prox;
}


int removerInicio() {
    if (primeiro == ultimo) {
        errx(1, "Erro ao remover (vazia)!");
    }

    CelulaDupla* tmp = primeiro;
    primeiro = primeiro->prox;
    int resp = primeiro->elemento;
    tmp->prox = primeiro->ant = NULL;
    free(tmp);
    tmp = NULL;
    return resp;
}


int removerFim() {
    if (primeiro == ultimo) {
        errx(1, "Erro ao remover (vazia)!");
    } 
    int resp = ultimo->elemento;
    ultimo = ultimo->ant;
    ultimo->prox->ant = NULL;
    free(ultimo->prox);
    ultimo->prox = NULL;
    return resp;
}


int tamanho() {
    int tamanho = 0; 
    CelulaDupla* i;
    for(i = primeiro; i != ultimo; i = i->prox, tamanho++);
    return tamanho;
}


void inserir(int x, int pos) {

    int tam = tamanho();

    if(pos < 0 || pos > tam){
        errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
    } else if (pos == 0){
        inserirInicio(x);
    } else if (pos == tam){
        inserirFim(x);
    } else {
        CelulaDupla* i = primeiro;
        int j;
        for(j = 0; j < pos; j++, i = i->prox);

        CelulaDupla* tmp = novaCelulaDupla(x);
        tmp->ant = i;
        tmp->prox = i->prox;
        tmp->ant->prox = tmp->prox->ant = tmp;
        tmp = i = NULL;
    }
}

int remover(int pos) {
    int resp;
    int tam = tamanho();

    if (primeiro == ultimo){
        errx(1, "Erro ao remover (vazia)!");
    } else if(pos < 0 || pos >= tam){
        errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
    } else if (pos == 0){
        resp = removerInicio();
    } else if (pos == tam - 1){
        resp = removerFim();
    } else {
        CelulaDupla* i = primeiro->prox;
        int j;
        for(j = 0; j < pos; j++, i = i->prox);

        i->ant->prox = i->prox;
        i->prox->ant = i->ant;
        resp = i->elemento;
        i->prox = i->ant = NULL;
        free(i);
        i = NULL;
    }

    return resp;
}


void mostrar() {
    CelulaDupla* i;
    printf("[ ");
    for (i = primeiro->prox; i != NULL; i = i->prox) {
        printf("%d ", i->elemento);
    }
    printf("] \n");
}


void mostrarInverso() {
    printf("[ ");
    CelulaDupla* i;
    for (i = ultimo; i != primeiro; i = i->ant){
        printf("%d ", i->elemento);
    }
    printf("] \n");
}


bool pesquisar(int x) {
    bool resp = false;
    CelulaDupla* i;

    for (i = primeiro->prox; i != NULL; i = i->prox) {
        if(i->elemento == x){
            resp = true;
            i = ultimo;
        }
    }
    return resp;
}

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
    }
    return ( exist );
}

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
        }
    }
    return ( perso );
} 

void delete_Personagem( Personagem *perso )
{
    if( perso != NULL )
    {
        if( exist_Personagem( perso ) ) 
        {
            free( perso->id ); 
            perso->id  = NULL;

            free( perso->name );
            perso->name = NULL;

            free( perso->alternateNames ); 
            perso->alternateNames = NULL;

            free( perso->house ); 
            perso->house  = NULL;

            free( perso->ancestry  ); 
            perso->ancestry  = NULL;

            free( perso->species  ); 
            perso->species = NULL;

            free( perso->patronus ); 
            perso->patronus  = NULL;

            free( perso->actorName  ); 
            perso->actorName = NULL;

            free( perso->alternateActors ); 
            perso->alternateActors = NULL;

            free( perso->dateOfBirth ); 
            perso->dateOfBirth = NULL;

            free( perso->eyeColour ); 
            perso->eyeColour = NULL;
        }
        free( perso ); perso = NULL;  
    } 
} 


char* getId( Personagem *perso ) 
{ 
    return ( perso->id ); 
}

char* getName( Personagem *perso ) 
{ 
    return ( perso->name ); 
}

char* getAlternateNames( Personagem *perso ) 
{ 
    return ( perso->alternateNames  ); 
}

char* getHouse( Personagem *perso ) 
{ 
    return ( perso->house           ); 
}

char* getAncestry ( Personagem *perso ) 
{
    return ( perso->ancestry); 
}

char* getSpecies( Personagem *perso ) 
{ 
    return ( perso->species ); 
}

char* getPatronus( Personagem *perso ) 
{ 
    return ( perso->patronus ); 
}

bool  getHogwartsStaff( Personagem *perso ) 
{
    return ( perso->hogwartsStaff   ); 
}

bool  getHogwartsStudent( Personagem *perso ) 
{ 
    return ( perso->hogwartsStudent ); 
}

char* getActorName( Personagem *perso ) 
{ 
    return ( perso->actorName ); 
}

bool  getAlive( Personagem *perso ) 
{ 
    return ( perso->alive ); 
}

char* getAlternateActors( Personagem *perso ) 
{ 
    return ( perso->alternateActors ); 
}

char* getDateOfBirth( Personagem *perso ) 
{ 
    return ( perso->dateOfBirth ); 
}

int   getYearOfBirth( Personagem *perso ) 
{ 
    return ( perso->yearOfBirth ); 
}

char* getEyeColour( Personagem *perso ) 
{ 
    return ( perso->eyeColour); 
}

char* getGender( Personagem *perso ) 
{ 
    return ( perso->gender  ); 
}

char* getHairColour( Personagem *perso ) 
{ 
    return ( perso->hairColour ); 
}

bool  getWizard( Personagem *perso ) 
{ 
    return ( perso->wizard  ); 
}


void setId( Personagem *perso, char* id ) 
{ 
    strcpy( perso->id , id ) ; 
}

void setName( Personagem *perso, char* name ) 
{ 
    strcpy( perso->name , name ) ; 
}

void setAlternateNames( Personagem *perso, char* alternateNames  ) 
{ 
    strcpy( perso->alternateNames , alternateNames ) ; 
} 

void setHouse( Personagem *perso, char* house ) 
{ 
    strcpy( perso->house , house ) ; 
}

void setAncestry( Personagem *perso, char* ancestry ) 
{ 
    strcpy( perso->ancestry , ancestry ) ; 
}

void setSpecies( Personagem *perso, char* species ) 
{ 
    strcpy( perso->species , species ) ; 
}

void setPatronus( Personagem *perso, char* patronus) 
{ 
    strcpy( perso->patronus  , patronus ) ; 
}

void setHogwartsStaff( Personagem *perso, bool  hogwartsStaff ) 
{         
    perso->hogwartsStaff  = hogwartsStaff ; 
}

void setHogwartsStudent( Personagem *perso, bool  hogwartsStudent ) 
{         
    perso->hogwartsStudent = hogwartsStudent ; 
}

void setActorName( Personagem *perso, char* actorName ) 
{ 
    strcpy( perso->actorName , actorName ) ; 
}

void setAlive( Personagem *perso, bool  alive ) 
{         
    perso->alive = alive ; 
}

void setAlternateActors( Personagem *perso, char* alternateActors ) 
{ 
    strcpy( perso->alternateActors , alternateActors) ; 
}

void setDateOfBirth( Personagem *perso, char* dateOfBirth ) 
{ 
    strcpy( perso->dateOfBirth , dateOfBirth ) ; 
}

void setYearOfBirth( Personagem *perso, int   yearOfBirth     ) 
{         
    perso->yearOfBirth = yearOfBirth ; 
}

void setEyeColour( Personagem *perso, char* eyeColour ) 
{ 
    strcpy( perso->eyeColour , eyeColour ) ; 
}

void setGender ( Personagem *perso, char* gender ) 
{ 
    strcpy( perso->gender  , gender  ) ; 
}

void setHairColour( Personagem *perso, char* hairColour      ) 
{ 
    strcpy( perso->hairColour , hairColour ) ; 
}

void setWizard( Personagem *perso, bool  wizard ) 
{         
    perso->wizard  = wizard  ; 
}

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
    } 
} 

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
    }
    return ( copy );
} 

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
} 
char* tratamentoBool( char* strbool )
{
    char* tratada = strbool;
    tratada[strcspn(tratada,"\n")] = '\0';
    tratada[strcspn(tratada,"\r")] = '\0';
    return ( tratada );
} 
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
    } 
    return ( tratada );
} 
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

        fgets( line, sizeof(line), file );
        while( fgets( line, sizeof(line), file ) != NULL && !idFound ) 
        {
            char* token = strtok( line, ";" );
            char *atributos[18];
            int index = 0;
            while( token != NULL ) 
            {
                atributos[index++] = strdup( token );
                token = strtok( NULL, ";" );
            } 

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
            free( atributos[2] ) ; atributos[2] = strdup(temp);

            if( strcmp(atributos[0], id_procurado) == 0 ) 
            {
                idFound = true;
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
                    } 
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
                } 
            } 
            for (int x = 0; x < index; x++) {
                free(atributos[x]);
            } 
        }  
        fclose(file);
    } 
    return ( perso );
} 
void swap ( int i, int j, Personagem **perso )
{
    Personagem *temp = perso[i];
    perso[i] = perso[j];
    perso[j] = temp;
} 
void quicksortRec( Personagem** perso, int esq, int dir) 
{
    int i = esq, j = dir;
    char* pivo = getHouse( perso[(dir+esq)/2] );
    while( i <= j ) 
    {
        while( strcmp( getHouse( perso[i] ), pivo ) < 0 ) {
            i++;
        } 
        while( strcmp( getHouse( perso[j] ), pivo ) > 0 ) {
            j--;
        } 
        if( i <= j ) 
        {
            swap( i, j, perso );
            i++;
            j--;
        } 
    } 
    if( esq < j ) {
        quicksortRec( perso, esq, j);
    } 
    if( i < dir ) {
        quicksortRec( perso, i, dir);
    } 
}
void sortByName( Personagem** perso, int length)
{
    for( int i = 0; i < length; i = i + 1 )
    {
        int menor = i;
        for( int j = i + 1; j < length; j = j + 1 )
        {
            if( strcmp( getHouse(perso[menor]), getHouse(perso[j]) ) == 0 &&
                strcmp( getName(perso[menor]), getName(perso[j]) ) > 0 )
            {
                menor = j;
            } 
        } 
        swap( menor, i, perso );
    } 
} 
void quicksort( Personagem** perso, int length) 
{
    quicksortRec( perso, 0, length-1);
    sortByName( perso, length);
} 
int main ( void )
{
    setlocale( LC_CTYPE, "UTF-8" ); 

    Personagem* perso[100] = { NULL };

    char id  [81] = { '\0' };
    char nome[81] = { '\0' };
    char* filename = "/tmp/characters.csv"; 
    
    scanf( "%s", id ); getchar( );
    int tam = 0;
    while( strcmp( id,"FIM" ) != 0 )
    {
        perso[tam] = ler( filename, id );
        tam++;
        scanf( "%s", id ); getchar( );
    } 

    quicksort( perso, tam);
    
    for( int x = 0; x < tam; x = x + 1 ) {
        imprimir( perso[x] );
        delete_Personagem( perso[x] );
    } 

    return ( 0 );
}
