package cmn.utilslib.essentials;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class WeakList<T> extends AbstractList<T>
{
   private ArrayList<WeakReference<T>> items;

    /** Creates new WeakList */
    public WeakList()
    {
        items = Auto.ArrayList();
    }
    
    public WeakList(Collection<T> c)
    {
        items = Auto.ArrayList();
        addAll(0, c);
    }
    
    public void add(int index, T element)
    {
        items.add(index, new WeakReference<T>(element));
    }
    
    public Iterator<T> iterator()
    {
        return new WeakListIterator();
    }
    
    public int size()
    {
        removeReleased();
        return items.size();
    }    
    
    public T get(int index)
    {
        return ((WeakReference<T>) items.get(index)).get();
    }
    
    private void removeReleased()
    {
        for (Iterator<WeakReference<T>> it = items.iterator(); it.hasNext(); )
        {
            WeakReference<T> ref = (WeakReference<T>) it.next();
            if (ref.get() == null) items.remove(ref);
        }
    }
    
    private class WeakListIterator implements Iterator<T>
    {
        
        private int n;
        private int i;
        
        public WeakListIterator()
        {
            n = size();
            i = 0;
        }
        
        public boolean hasNext()
        {
            return i < n;
        }
        
        public T next() {
            return get(i++);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }

}
