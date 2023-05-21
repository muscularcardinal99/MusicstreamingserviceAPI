package com.geekster.MusicStreaming.service;

import com.geekster.MusicStreaming.model.AuthenticationToken;
import com.geekster.MusicStreaming.model.PlayList;
import com.geekster.MusicStreaming.model.Song;
import com.geekster.MusicStreaming.model.User;
import com.geekster.MusicStreaming.repo.IPlayListRepo;
import com.geekster.MusicStreaming.repo.ISongRepo;
import com.geekster.MusicStreaming.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayListService {

    @Autowired
    TokenService tokenService;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IPlayListRepo playListRepo;

    @Autowired
    ISongRepo songRepo;


    public String addPlayList(String token, PlayList playList) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        user.setPlayList(playList);
        userRepo.save(user);
        return "PlayList added successfully";
    }

    public PlayList getPlayList(String token, String email) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        return user.getPlayList();
    }

    public String deletePlayList(String token) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();

        if(user.getPlayList()==null){
            return "PlayList doesn't exist";
        }
        playListRepo.deleteById(user.getPlayList().getPlayListId());
        return "PlayList deleted successfully";
    }

    public String updatePlayList(String token, Long id) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        List<Song> songList = user.getPlayList().getSongs();

        for(Song song : songList){
            if(song.getSongId()==id){
                return "Song already exists in playList";
            }
        }

        Song song = songRepo.findById(id).get();
        songList.add(song);
        user.getPlayList().setSongs(songList);
        userRepo.save(user);
        return "Song added in playList";
    }

    public String deleteFromPlayList(String token, Long id) {
        AuthenticationToken token1 = tokenService.tokenRepo.findFirstByToken(token);
        User user = token1.getUser();
        List<Song> songList = user.getPlayList().getSongs();


        for(int i=0 ; i<songList.size() ; i++){
            if(songList.get(i).getSongId()==id){
                songList.remove(i);
                user.getPlayList().setSongs(songList);
                userRepo.save(user);
                return "Song deleted in playList";
            }
        }




        return "Song doesnot exist in playList";
    }
}
