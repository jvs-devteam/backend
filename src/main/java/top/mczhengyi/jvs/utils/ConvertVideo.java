package top.mczhengyi.jvs.utils;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;

public class ConvertVideo {

    private static final String ffmpegPath = ConfigUtils.getFfmpegPath();
    private static final String basePath = EnvUtils.getUploadPath();

    /**
     * 检查文件是否为视频格式，以及能否被FFmpeg转换
     * @param fileName 文件名
     * @return 0 不是视频格式, 1 能被FFmpeg转换的视频, 2 不能被FFmpeg转换的视频
     */
    public static Integer checkVideoFormat(String fileName) {
        String extension = FilenameUtils.getExtension(fileName).toLowerCase();
        switch (extension) {
            case "mp4":
                return 1;
            case "mkv":
            case "webm":
            case "avi":
                return 0;
        }
        return 0;
    }

//    public static String convertVideo(String uncompressFilePath) {
//        String filename = FileNameUtils.getRandomVideoFileName() + ".mp4";
//        List<String> command = new ArrayList<>();
//        command.add(ffmpegPath + "/ffmpeg");
//        command.add("-y");
//        command.add("-i");
//        command.add(basePath + "/" + uncompressFilePath);
//        command.add("-c:v libx264");
//        command.add(basePath + "/" + filename);
//        try {
//            ProcessBuilder builder = new ProcessBuilder(command);
//            builder.command(command);
//            System.out.println(command.toString());
//            Process start = builder.start();
//            return "/" + filename;
//        } catch (IOException e) {
//            return null;
//        }
//    }

    public static String convertVideo(String uncompressFilePath) throws IOException {
        String filename = JvsFileUtils.getRandomVideoFileName() + ".mp4";
        FFmpeg ffmpeg = new FFmpeg(ffmpegPath + "/ffmpeg");
        FFprobe ffprobe = new FFprobe(ffmpegPath + "/ffprobe");

        FFmpegBuilder builder = new FFmpegBuilder()

                .setInput(basePath + "/" + uncompressFilePath)     // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(true) // Override the output if it exists

                .addOutput(basePath + "/" + filename)   // Filename for the destination
                .setFormat("mp4")        // Format is inferred from filename, or can be set
                .setVideoBitRate(8000000)

                .disableSubtitle()       // No subtiles

                .setAudioChannels(1)         // Mono audio
                .setAudioCodec("aac")        // using the aac codec
                .setAudioSampleRate(48_000)  // at 48KHz
                .setAudioBitRate(32768)      // at 32 kbit/s

                .setVideoCodec("libx264")     // Video using x264
                .setVideoFrameRate(24, 1)     // at 24 frames per second

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

// Run a one-pass encode
        executor.createJob(builder).run();

// Or run a two-pass encode (which is better quality at the cost of being slower)
        executor.createTwoPassJob(builder).run();
        return filename;
    }

}
