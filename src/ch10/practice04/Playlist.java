package ch10.practice04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Playlist {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();

    public void append(Song song){
        tracks.add(song);
        singers.put(song.getSinger(), song.getTitle());
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }
}
class PersonalPlaylist extends Playlist{
    //상속에 의해서 자식클래스도 전부 수정해야 하는 문제가 발생한다.
    //상속 => 부모 클래스를 전부 알고있어야 함을 강제당함
    public void remove(Song song){
        getTracks().remove(song);
        getSingers().remove(song.getSinger());
    }
}