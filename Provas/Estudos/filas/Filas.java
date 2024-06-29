package Provas.P1.filas;

import java.util.Random;

public class Filas 
{
    // ---------------------------------------- atributos

    protected int[] array;     // arranjo
    protected int   size;      // tamanho real
    protected int   capacity;  // capacidade total

    // ---------------------------------------- Construtores

    public Filas( ) 
    {
        this(10); // capacidade padrao de 10
    } // end Lista ( );

    public Filas( int length ) 
    {
        if( length > 0 )
        {
            this.capacity = length+4;
            this.array = new int[this.capacity];
            this.size = length;
        } // end if
    } // end Lista ( )

    // ---------------------------------------- GETs / SETs

    public int getSize( ) 
    {
        return ( this.size );
    } // end getSize ( )

    public int getCapacity( ) 
    {
        return ( this.capacity );
    } // end getCapacity ( )

    public void set( int index, int value )
    {
        this.array[index] = value;
    } // end set ( )

    public int get( int index )
    {
        int value = 0;
        if( index >= 0 && index < size )
        {
            value = this.array[index];
        } // end if
        return ( value );
    } // end get ( )

    // ----------------------------------------  Outros Metodos

    private void increaseCapacity( ) 
    {
        int newCapacity = capacity * 2; // Aumenta em 50%
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size); // Copia os elementos para o novo array
        System.arraycopy(newArray, 0, array, 0, size); // Copia os elementos para o novo array
        array = newArray;
        capacity = newCapacity;
    } // end increaseCapacity ( )

    public void add( int value ) 
    {
        if( size >= capacity ) 
        {
            increaseCapacity( ); // Aumenta a capacidade se necessário
        } // end if
        array[size++] = value;
    } // end add ( )

    public void randValue( ) 
    {
        Random gerador = new Random( );
        for( int x = 0; x < size; x = x + 1 )
        {
            array[x] = Math.abs( gerador.nextInt( ) % 50 );
        } // end for
    } // end randValue ( )

    public void printLista( )
    {
        System.out.print( "[ " );
        for( int x = 0; x < size; x = x + 1 )
        {
            System.out.print( array[x] + " " );
        } // end for
        System.out.println( "]" );
    } // end printLista ( )

    // ---------------------------------------- Metodos de Pesquisa

    public boolean pesquisaSequencial( int value )
    {
        boolean result = false;
        for( int x = 0; x < size && !result; x = x + 1 )
        {
            if( array[x] == value )
            {
                result = true;
            } // end if
        } // end for
        return ( result );
    } // end pesquisaSequencial ( )

    public int pesquisaBinaria( int value, int esq, int dir )
    {
        if( esq > dir )
        {
            return -1; // nao encontrado
        }
        else
        {
            int meio = ( esq+dir ) / 2;
            if (value == array[meio] )
            {
                return meio;
            } 
            else if( value > array[meio] )
            {
                return pesquisaBinaria( value, meio + 1, dir );
            } 
            else 
            {
                return pesquisaBinaria( value, esq, meio - 1 );
            } // end if	
        } // end if
    } // end pesquisaBinaria ( )

    // ---------------------------------------- Metodos de Ordenacao

    public void bubbleSort( )
    {
        for( int x = 1; x < size; x = x + 1 )
        {
            for( int y = 1; y < size; y = y + 1 )
            {
                if( array[y] > array[y+1] )
                {
                    int temp = array[y+1];
                    array[y+1] = array[y];
                    array[y] = temp;
                } // end if
            } // end for
        } // end for
    } // end bubbleSort ( )

    public void bubbleSortBest( )
    {
        boolean houveTroca = true;
        for( int x = 0; x < size-1 && houveTroca; x = x + 1 )
        {
            houveTroca = false;
            for( int y = 0; y < size-x-1; y = y + 1 )
            {
                if( array[y] > array[y+1] )
                {
                    int temp = array[y+1];
                    array[y+1] = array[y];
                    array[y] = temp;
                    houveTroca = true;
                } // end if
            } // end for
        } // end for
    } // end bubbleSortBest ( )

    public void insertionSort( )
    {
        for( int x = 1; x < array.length; x = x + 1 ) 
        {
            int y = x;
            while( y >= 0 && array[y-1] > array[y] ) 
            {
                int temp = array[y-1];
                array[y-1] = array[y];
                array[y] = temp;
                y--;
            } // end while
        } // end for
    } // end insertionSort ( )

    // ---------------------------------------- Metodos de Insercao e Remocao

    public int removerInicio( )
    {
        int value = 0;
        if( size > 0 )
        {
            value = array[0];
            for( int x = 1; x < size; x = x + 1 )
            {
                array[x-1] = array[x];
            } // end for
            size--;
        } // end if
        return ( value );
    } // end removerInicio ( )

    public int removerFim( )
    {
        int value = 0;
        if( size > 0 )
        {
            value = array[size-1];
            size--;
        } // end if
        return ( value );
    } // removerFim ( )

    public void inserirInicio( int value )
    {
        if( size < capacity )
        {
            for( int x = size-1; x >= 0; x-- ) 
            {
                array[x+1] = array[x];
            } // end for
            array[0] = value;
            size++;
        } // end if
    } // end inserirInicio ( )

    public void inserirFim( int value )
    {
        if( size < capacity )
        {
            array[size] = value;
            size++;
        }
        else
        {
            increaseCapacity();
            array[size] = value;
            size++;
        } // end if
    } // end inserirFim ( )
} // end class 