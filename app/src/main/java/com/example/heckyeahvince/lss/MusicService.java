package com.example.heckyeahvince.lss;

/**
 * Created by heckyeahvince on 10/5/2015.
 */
    import android.app.Service;
    import android.content.Intent;
    import android.content.res.AssetFileDescriptor;
    import android.media.MediaPlayer;
    import android.os.IBinder;
    import android.widget.Toast;

    import java.io.IOException;

    public class MusicService extends Service {

        public static final String ACTION_PLAY = "play";
        public static final String ACTION_STOP = "stop";

        private MediaPlayer player;

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {

            String action = intent.getAction();

            if (action.equals(ACTION_PLAY)) {
                String filename = intent.getStringExtra("filename");

                // stop any previous playing song
                if (player != null && player.isPlaying()) {
                    player.stop();
                    player.release();
                }

                try {
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd(filename);
                    player = new MediaPlayer();
                    player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    player.prepare();
                    player.setLooping(true);
                    player.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (action.equals(ACTION_STOP)) {
                // stop any currently playing song
                if (player != null && player.isPlaying()) {
                    player.stop();
                    // player.release(); // causes IllegalStateException
                }
            }
            return START_NOT_STICKY;
        }

        @Override
        public void onDestroy() {
            Toast.makeText(this, "My Music Service Stopped", Toast.LENGTH_SHORT).show();
            player.stop();
            player.release();
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }