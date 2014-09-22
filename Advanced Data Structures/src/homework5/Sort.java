package homework5;

import java.util.Arrays;

    /**
     * A class that contains several sorting routines,
     * implemented as static methods.
     * Arrays are rearranged with smallest item first,
     * using compareTo.
     * @author Mark Allen Weiss
     * 
     * modified to return the number of comparisons made
     */
    public final class Sort
    {
        /**
         * Simple insertion sort.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		public static long insertionSort( Comparable [ ] a )
        {
            int j;
            long numOfComps = 0;

/* 1*/      for( int p = 1; p < a.length; p++ )
            {
/* 2*/          Comparable tmp = a[ p ];
/* 3*/          for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
				{	
/* 4*/              a[ j ] = a[ j - 1 ];
					numOfComps++;
				}
/* 5*/          a[ j ] = tmp;
            }
	
			return numOfComps;
        }

        /**
         * Shellsort, using Shell's (poor) increments.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		public static long shellsortOriginal( Comparable [ ] a )
        {
            int j;
            long numOfComps = 0;

/* 1*/      for( int gap = a.length / 2; gap > 0; gap /= 2 )
/* 2*/          for( int i = gap; i < a.length; i++ )
                {
/* 3*/              Comparable tmp = a[ i ];
/* 4*/              for( j = i; j >= gap &&
                                tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
					{
/* 5*/                  a[ j ] = a[ j - gap ];
						numOfComps++;
					}
/* 6*/              a[ j ] = tmp;
                }
			return numOfComps;
        }


        /**
         * Standard heapsort.
         * @param a an array of Comparable items.
         * @return 
         */
        @SuppressWarnings("rawtypes")
		public static long heapsort( Comparable [ ] a )
        {
        	long comp1 = 0, comp2 = 0;
        	
/* 1*/      for( int i = a.length / 2; i >= 0; i-- )  /* buildHeap */
/* 2*/          comp1 += percDown( a, i, a.length );
/* 3*/      for( int i = a.length - 1; i > 0; i-- )
            {
/* 4*/          swapReferences( a, 0, i );            /* deleteMax */
/* 5*/          comp2 += percDown( a, 0, i );
            }

			return comp1 + comp2;
        }

        /**
         * Internal method for heapsort.
         * @param i the index of an item in the heap.
         * @return the index of the left child.
         */
        private static int leftChild( int i )
        {
            return 2 * i + 1;
        }

        /**
         * Internal method for heapsort that is used in
         * deleteMax and buildHeap.
         * @param a an array of Comparable items.
         * @return 
         * @index i the position from which to percolate down.
         * @int n the logical size of the binary heap.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		private static long percDown( Comparable [ ] a, int i, int n )
        {
            int child;
            Comparable tmp;
            long numOfComps = 0;

/* 1*/      for( tmp = a[ i ]; leftChild( i ) < n; i = child )
            {
/* 2*/          child = leftChild( i );
/* 3*/          if( child != n - 1 && a[ child ].compareTo( a[ child + 1 ] ) < 0 )
/* 4*/              child++;
/* 5*/          if( tmp.compareTo( a[ child ] ) < 0 )
				{
/* 6*/              a[ i ] = a[ child ];
					numOfComps++;
				}
                else
                {
                	numOfComps++;
/* 7*/              break;
                }
            }
/* 8*/      a[ i ] = tmp;
			return numOfComps;
        }

        /**
         * Mergesort algorithm.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings("rawtypes")
		public static long mergeSort( Comparable [ ] a )
        {
            Comparable [ ] tmpArray = new Comparable[ a.length ];

            return mergeSort( a, tmpArray, 0, a.length - 1 );
        }

        /**
         * Internal method that makes recursive calls.
         * @param a an array of Comparable items.
         * @param tmpArray an array to place the merged result.
         * @param left the left-most index of the subarray.
         * @param right the right-most index of the subarray.
         * @return 
         */
        @SuppressWarnings("rawtypes")
		private static long mergeSort( Comparable [ ] a, Comparable [ ] tmpArray,
                   int left, int right )
        {
        	long numOfComps = 0;
        	
            if( left < right )
            {
                int center = ( left + right ) / 2;
                numOfComps += mergeSort( a, tmpArray, left, center );
                numOfComps += mergeSort( a, tmpArray, center + 1, right );
                numOfComps += merge( a, tmpArray, left, center + 1, right );
                numOfComps++;
            }
            return numOfComps;
        }

        /**
         * Internal method that merges two sorted halves of a subarray.
         * @param a an array of Comparable items.
         * @param tmpArray an array to place the merged result.
         * @param leftPos the left-most index of the subarray.
         * @param rightPos the index of the start of the second half.
         * @param rightEnd the right-most index of the subarray.
         * @return 
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		private static long merge( Comparable [ ] a, Comparable [ ] tmpArray,
               int leftPos, int rightPos, int rightEnd )
        {
        	long numOfComps = 0;
        	
            int leftEnd = rightPos - 1;
            int tmpPos = leftPos;
            int numElements = rightEnd - leftPos + 1;

            // Main loop
            while( leftPos <= leftEnd && rightPos <= rightEnd )
                if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 )
                {
                    tmpArray[ tmpPos++ ] = a[ leftPos++ ];
                    numOfComps++;
                }
                else
                {
                    tmpArray[ tmpPos++ ] = a[ rightPos++ ];
                    numOfComps++;
                }

            while( leftPos <= leftEnd )    // Copy rest of first half
                {tmpArray[ tmpPos++ ] = a[ leftPos++ ]; numOfComps++;}

            while( rightPos <= rightEnd )  // Copy rest of right half
                {tmpArray[ tmpPos++ ] = a[ rightPos++ ]; numOfComps++;}

            // Copy tmpArray back
            for( int i = 0; i < numElements; i++, rightEnd-- )
                a[ rightEnd ] = tmpArray[ rightEnd ];
            
            return numOfComps;
        }//end merge

        /**
         * Quicksort algorithm.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings("rawtypes")
		public static long quicksort( Comparable [ ] a )
        {
            return quicksort( a, 0, a.length - 1 );
        }

        private static final int CUTOFF = 10;

        /**
         * Method to swap to elements in an array.
         * @param a an array of objects.
         * @param index1 the index of the first object.
         * @param index2 the index of the second object.
         */
        public static final void swapReferences( Object [ ] a, int index1, int index2 )
        {
            Object tmp = a[ index1 ];
            a[ index1 ] = a[ index2 ];
            a[ index2 ] = tmp;
        }

        /**
         * Return median of left, center, and right.
         * Order these and hide the pivot.
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
		private static Comparable median3( Comparable [ ] a, int left, int right )
        {
            int center = ( left + right ) / 2;
            if( a[ center ].compareTo( a[ left ] ) < 0 )
                swapReferences( a, left, center );
            if( a[ right ].compareTo( a[ left ] ) < 0 )
                swapReferences( a, left, right );
            if( a[ right ].compareTo( a[ center ] ) < 0 )
                swapReferences( a, center, right );

                // Place pivot at position right - 1
            swapReferences( a, center, right - 1 );
            return a[ right - 1 ];
        }

        /**
         * Internal quicksort method that makes recursive calls.
         * Uses median-of-three partitioning and a cutoff of 10.
         * @param a an array of Comparable items.
         * @param left the left-most index of the subarray.
         * @param right the right-most index of the subarray.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		private static long quicksort( Comparable [ ] a, int left, int right )
        {
/* 1*/      long numOfComps = 0;
        	
        	if( left + CUTOFF <= right )
            {
        		numOfComps++;
/* 2*/          Comparable pivot = median3( a, left, right );

                    // Begin partitioning
/* 3*/          int i = left, j = right - 1;
/* 4*/          for( ; ; )
                {
/* 5*/              while( a[ ++i ].compareTo( pivot ) < 0 ) { }
/* 6*/              while( a[ --j ].compareTo( pivot ) > 0 ) { }
/* 7*/              if( i < j )
/* 8*/                  {swapReferences( a, i, j ); numOfComps++;}
                    else
/* 9*/                  {numOfComps++; break;}
                }

/*10*/          swapReferences( a, i, right - 1 );   // Restore pivot

/*11*/          numOfComps += quicksort( a, left, i - 1 );    // Sort small elements
/*12*/          numOfComps += quicksort( a, i + 1, right );   // Sort large elements
            }
            else  // Do an insertion sort on the subarray
/*13*/          numOfComps += insertionSort( a, left, right );
        	
        	return numOfComps;
        }//end quicksort private

        /**
         * Internal insertion sort routine for subarrays
         * that is used by quicksort.
         * @param a an array of Comparable items.
         * @param left the left-most index of the subarray.
         * @param right the right-most index of the subarray.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		private static long insertionSort( Comparable [ ] a, int left, int right )
        {
        	
        	long numOfComps = 0;
            for( int p = left + 1; p <= right; p++ )
            {
                Comparable tmp = a[ p ];
                int j;
                

                for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                    {a[ j ] = a[ j - 1 ]; numOfComps++;}
                a[ j ] = tmp;
            }
            return numOfComps;
        }

        /**
         * Quick selection algorithm.
         * Places the kth smallest item in a[k-1].
         * @param a an array of Comparable items.
         * @param k the desired rank (1 is minimum) in the entire array.
         */     
        @SuppressWarnings("rawtypes")
		public static void quickSelect( Comparable [ ] a, int k )
        {
            quickSelect( a, 0, a.length - 1, k );
        }

        /**
         * Internal selection method that makes recursive calls.
         * Uses median-of-three partitioning and a cutoff of 10.
         * Places the kth smallest item in a[k-1].
         * @param a an array of Comparable items.
         * @param left the left-most index of the subarray.
         * @param right the right-most index of the subarray.
         * @param k the desired index (1 is minimum) in the entire array.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		private static void quickSelect( Comparable [ ] a, int left,
                                                int right, int k )
        {
/* 1*/      if( left + CUTOFF <= right )
            {
/* 2*/          Comparable pivot = median3( a, left, right );

                    // Begin partitioning
/* 3*/          int i = left, j = right - 1;
/* 4*/          for( ; ; )
                {
/* 5*/              while( a[ ++i ].compareTo( pivot ) < 0 ) { }
/* 6*/              while( a[ --j ].compareTo( pivot ) > 0 ) { }
/* 7*/              if( i < j )
/* 8*/                  swapReferences( a, i, j );
                    else
/* 9*/                  break;
                }

/*10*/          swapReferences( a, i, right - 1 );   // Restore pivot

/*11*/          if( k <= i )
/*12*/              quickSelect( a, left, i - 1, k );
/*13*/          else if( k > i + 1 )
/*14*/              quickSelect( a, i + 1, right, k );
            }
            else  // Do an insertion sort on the subarray
/*15*/          insertionSort( a, left, right );
        }

        /**
         * Shellsort, using Hibbards's increments.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		public static long shellsortHibbard( Comparable [ ] a )
        {
            int j;
            long numOfComps = 0;
               
            //loop to change
/* 1*/      for( int gap = (int) Math.pow(2, a.length); gap > 0; gap /= 2 )
/* 2*/          for( int i = gap; i < a.length; i++ )
                {
/* 3*/              Comparable tmp = a[ i ];
/* 4*/              for( j = i; j >= gap &&
                                tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
					{
/* 5*/                  a[ j ] = a[ j - gap ];
						numOfComps++;
					}
/* 6*/              a[ j ] = tmp;
                }
			return numOfComps;
        }
        
        
        /**
         * Shellsort, using Sedgewick's increments.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		public static long shellsortSedgewick( Comparable [ ] a )
        {
            int j;
            long numOfComps = 0;
               
            //loop to change
/* 1*/      for( int gap = (int) Math.ceil(2 * (a.length / 4) + 1); gap > 0; gap /= 2 )
/* 2*/          for( int i = gap; i < a.length; i++ )
                {
/* 3*/              Comparable tmp = a[ i ];
/* 4*/              for( j = i; j >= gap &&
                                tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
					{
/* 5*/                  a[ j ] = a[ j - gap ];
						numOfComps++;
					}
/* 6*/              a[ j ] = tmp;
                }
			return numOfComps;
        }
        
        /**
         * Shellsort, using Ciura's increments.
         * @param a an array of Comparable items.
         */
        @SuppressWarnings({ "rawtypes", "unchecked" })
		public static long shellsortCiura( Comparable [ ] a )
        {
            long numOfComps = 0;          
            java.util.List<Integer> incs = Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1);
            
            int j;
            //loop to change
/* 1*/      for( Integer gap : incs )
			{
/* 2*/          for( int i = gap; i < a.length; i++)
                {
/* 3*/              Comparable tmp = a[ i ];
/* 4*/              for(j = i; j >= gap &&
                                tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
					{
/* 5*/                  a[ j ] = a[ j - gap ];
						numOfComps++;
					}
/* 6*/              a[ j ] = tmp;
                }
			}
			return numOfComps;
        }
        
    }//end class
