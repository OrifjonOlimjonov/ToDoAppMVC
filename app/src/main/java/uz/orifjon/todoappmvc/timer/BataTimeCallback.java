package uz.orifjon.todoappmvc.timer;

public interface BataTimeCallback {
     void onUpdate( int elapsed );
     void onComplete( );
}