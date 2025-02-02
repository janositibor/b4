package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels=new ArrayList<>();

    public void readDataFromFile(Path path){
        try(BufferedReader reader= Files.newBufferedReader(path)){
            reader.readLine();
            String line;
            while((line= reader.readLine())!=null){
                Channel channel=createChannelFromLine(line);
                channels.add(channel);
            }
        }catch(IOException ioe){
            throw new IllegalArgumentException("Cannot open file for read!");
        }
    }

    private Channel createChannelFromLine(String line) {
        String[] words=line.split(";");
        return new Channel(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]));
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public int calculateSumOfVideos() {
        return channels.stream().mapToInt(c->c.getNumberOfVideos()).sum();
    }
}
