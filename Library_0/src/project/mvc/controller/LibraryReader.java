package project.mvc.controller;

import project.mvc.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryReader{

    private List<LibraryBookModel> bookModels = new ArrayList<>();
    private List<String> backupList = new ArrayList<>();
    public LibraryReader(){}

    private void readFileIntoList() throws IOException {
        File file = new File("resources/Purchases.csv");

         Stream<String> lines = Files.lines(file.toPath()).filter(c -> c.contains(","));
            List<String> library = lines.collect(Collectors.toList());
            for (String line : library) {
                String[] lineParts = line.split(",");
                String format = "";
                if (lineParts.length == 4) {
                    format = lineParts[3];
                }
                LibraryBookModel book;
                switch (format) {
                    case "Hardcover":
                        book = new LibraryHardcoverModel();
                        break;
                    case "Audible":
                        book = new LibraryAudibleModel();
                        break;
                    case "Kindle":
                        book = new LibraryKindleModel();
                        break;
                    case "Box Set":
                        book = new LibraryBoxSetModel();
                        break;
                    case "DVD":
                        book = new LibraryDVDModel();
                        break;
                    default:
                        book = new LibraryPaperbackModel();
                }
                book.setTitle(lineParts[0]);

                String byAuthor = (!lineParts[1].isEmpty()) ? "by" + lineParts[1] : lineParts[1];
                book.setAuthor(byAuthor);

                book.setSku(lineParts[2]);
                book.setFormat();
                bookModels.add(book);

            }

    }

    public ArrayList<String> searchAndReturn(String keyword) throws IOException{
        if (bookModels.isEmpty()){
            readFileIntoList();
        }
        ArrayList<String> searchResults = new ArrayList<>();

        for (LibraryBookModel book : bookModels){
            String testTitle = book.getTitle();

            if (testTitle.toLowerCase().contains(keyword.toLowerCase())){
                searchResults.add(book.toString());
            }
        }
        return searchResults;
    }
    public void backUpLibrary(File newEmptyFile){
        try{
            FileWriter writeToNewFile = new FileWriter(newEmptyFile);
            writeToNewFile.write("\"Title\",\"Author\",\"SKU\",\"Format\"\n" +
                    "\"Cat In The Hats Learning Library\",\"Dr Seuss\",9780007947164,\"Box Set\"\n" +
                    "\"Lego - Ideas Book\",,9781405350679,\"Hardcover\"\n" +
                    "\"Richard III\",\"William Shakespeare\",9781846161858,\"Paperback\n" +
                    "\"\n" +
                    "\"A Shakespeare Story: Julius Caesar  translation missing: en.customer.order.fulfilled 19 Nov 12:20 FedEx #6200527645\",\"William Shakespeare\",9781408305065,\"Paperback\n" +
                    "\"\n" +
                    "\"King Lear\",\"William Shakespeare\",9781408305034,\"Paperback\n" +
                    "\"\n" +
                    "\"A Shakespeare Story: The Merchant of Venice\",\"William Shakespeare\",9781408305041,\"Paperback\n" +
                    "\"\n" +
                    "\"A Shakespeare Story: Macbeth\",\"William Shakespeare\",9781841213446,\"Paperback\n" +
                    "\"\n" +
                    "\"Henry IV\",\"William Shakespeare\",9781841213422,\"Paperback\n" +
                    "\"\n" +
                    "\"A Shakespeare Story: Romeo And Juliet\",\"William Shakespeare\",9781841213361,\"Paperback\n" +
                    "\"\n" +
                    "\"Tempest\",\"William Shakespeare\",9781841213460,\"Paperback\n" +
                    "\"\n" +
                    "\"A Shakespeare Story: Twelfth Night\",\"William Shakespeare\",9781841213347,\"Paperback\n" +
                    "\"\n" +
                    "\"A Shakespeare Story - A Midsummer Night's Dream\",\"William Shakespeare\",9781841213323,\"Paperback\n" +
                    "\"\n" +
                    "\"Shatter Me 05: Defy Me\",,9781405291798,\n" +
                    "\"Shatter Me 02: Unravel Me\",,9781405291767,\n" +
                    "\"Changeling: Demon Games \",,9780330517881,\n" +
                    "\"City of Time \",,9780007209798,\n" +
                    "\"The Best Ever Brain Teasers\",,9781784407773,\n" +
                    "\"Black Ice\",,9780330512008,\n" +
                    "\"Young Sherlock Holmes 4: Fire Storm\",,9780230758506,\n" +
                    "\"Young Sherlock Holmes: Death Cloud\",,9780330511988,\n" +
                    "\"The Eyeball Collector\",,9780230532281,\n" +
                    "\"The Bone Magician\",,9780330444828,\n" +
                    "\"The Lunatic's Curse\",,9780230532328,\n" +
                    "\"Cosmic\",,9780330440868,\n" +
                    "\"Bundu\",,9781415201091,\n" +
                    "\"The Roar\",,9781905294633,\n" +
                    "\"SIDEKICK\",,9780624049180,\n" +
                    "\"Midnight gate\",,9780330509008,\n" +
                    "\"Embroidery For Beginners\",,9781904760542,\n" +
                    "\"C.H.I.X: #1 Summer Gang\",,9781904442868,\n" +
                    "\"Pet School\",,9781842993347,\n" +
                    "\"Tithe Bk 1\",,9780857073617,\n" +
                    "\"Ironside Bk 3\",,9780857073600,\n" +
                    "\"Valiant Bk 2\",,9780857073594,\n" +
                    "\"The Lemonade War\",,9780545218634,\n" +
                    "\"The Shrieking Stones\",,9780141323725,\n" +
                    "\"English Dictionary\",,9781842054970,\n" +
                    "\"The Midnight Zoo\",,9781406331493,\n" +
                    "\"Here Lies Arthur\",,9781407103587,\n" +
                    "\"The Field Guide\",,9781847381958,\n" +
                    "\"Lucindas secret\",,9781847381972,\n" +
                    "\"The Spiderwick Chronicles #5: The Wrath Of Mulgarath\",,9781847381996,\n" +
                    "\"The Ironwood Tree\",,9781847381989,\n" +
                    "\"Changeling: Dark Moon\",,9780330470483,\n" +
                    "\"Changeling\",,9780330470476,\n" +
                    "\"The Stunning Science Of Everything\",,9780439959056,\n" +
                    "\"Our World\",,9781407571898,\n" +
                    "\"Ons Kan\",,9780799362800,\n" +
                    "\"Diep Diep In Die Donker Bos\",,9780799342826,\n" +
                    "\"Polar Lands\",,9780753411094,\n" +
                    "\"Gandhi\",,9781842056691,\n" +
                    "\"The Adventures of Tintin\",,9780857510754,\n" +
                    "\"Wilma Tenderfoot And The Case Of The Fatal Phantom\",,9780330469531,\n" +
                    "\"Trapped!\",,9781841357362,\n" +
                    "\"Shipwrecked!\",,9781841357348,\n" +
                    "\"The Secret Of Spiggy Holes\",,9781841356754,\n" +
                    "\"Secret Forest\",,9781841356778,\n" +
                    "\"The Secret Mountain\",,9781841356761,\n" +
                    "\"The Secret Valley\",,9781841356785,\n" +
                    "\"Secret Of Moon Castle\",,9781841356747,\n" +
                    "\"History'S Worst Decisions\",,9781770224339,\n" +
                    "\"Historys Lost Treasures\",,9781770226616,\n" +
                    "\"Winnie The Witch 10 Book Pack\",,9780192745958,\n" +
                    "\"Box Of Animal Stories\",,9781848698109,\"Box Set\"\n" +
                    "\"Behaviour Matters 6 Book Collection\",,9781445164298,\"Box Set\"\n" +
                    "\"Dragonsitter 8 Book Pack\",,9781783445608,\"Box Set\"\n" +
                    "\"Peppas Favourite Stories 10 Book Box-Set\",,9780723292562,\"Box Set\"\n" +
                    "\"Rewiring Education\",\"John D. Couch\",,\"Kindle\"\n" +
                    "\"Computational Thinking and Coding for Every Student\",\"Jane Krauss\",,\"Kindle\"\n" +
                    "\"Computational Fairy Tales\",\"Jeremy Kubica\",,\"Kindle\"\n" +
                    "\"A Calendar of Wisdom\",\"Leo Tolstoy\",,\"Kindle\"\n" +
                    "\"No Fear Coding: Computational Thinking Across the K-5 Curriculum\",\"Heidi Williams\",,\"Kindle\"\n" +
                    "\"Children of the Universe: Cosmic Education in the Montessori Elementary years\",\"Michael Duffy\",,\"Kindle\"\n" +
                    "\"The Big Book of Makerspace\",\"Colleen Graves\",,\"Kindle\"\n" +
                    "\"The President's Keepers: Those keeping Zuma in power and out of prison\",\"Jacques Pauw\",,\"Kindle\"\n" +
                    "\"Agile Marketing: Building Endurance for Your Content Marketing Team\",\"Jeff Julian\",,\"Kindle\"\n" +
                    "\"ASAP: Ages, Stages, and Phases\",\"Patricia D Fosarelli\",,\"Kindle\"\n" +
                    "\"Transformative Experience\",\"L. A. Paul\",,\"Kindle\"\n" +
                    "\"You Are Now Less Dumb\",\"David McRaney\",,\"Kindle\"\n" +
                    "\"The Absorbent Mind\",\"Maria Montessori\",,\"Kindle\"\n" +
                    "\"Spontaneous Activity in Education\",\"Maria Montessori\",,\"Kindle\"\n" +
                    "\"The Montessori Method\",\"Maria Montessori\",,\"Kindle\"\n" +
                    "\"Dr. Montessori's Own Handbook\",\"Maria Montessori\",,\"Kindle\"\n" +
                    "\"The Pragmatic Programmer: From Journeyman to Master\",\"Andrew Hunt\",,\"Kindle\"\n" +
                    "\"Design Patterns: Elements of Reusable Object-Oriented Software\",\"Erich Gamma\",,\"Kindle\"\n" +
                    "\"Montessori: The Science Behind the Genius\",\"Angeline Stoll Lillard\",,\"Kindle\"\n" +
                    "\"Mind in the Making\",\"Ellen Galinsky\",,\"Kindle\"\n" +
                    "\"Mindfulness: A practical guide to finding peace in a frantic world\",\"Prof. Mark Williams\",,\"Kindle\"\n" +
                    "\"Modern Buddhism: The Path of Compassion and Wisdom\",\"Geshe Kelsang Gyatso\",,\"Kindle\"\n" +
                    "\"The Robert C. Martin Clean Code Collection\",\"Robert C. Martin\",,\"Kindle\"\n" +
                    "\"Engineering Long-Lasting Software\",\"David Patterson\",,\"Kindle\"\n" +
                    "\"1,000 Ideas for Decorating Cupcakes, Cookies & Cakes\",\"Sandra Salamony\",,\"Kindle\"\n" +
                    "\"Celebrate with a Cake!\",\"Lindy Smith\",,\"Kindle\"\n" +
                    "\"The Fortune at the Bottom of the Pyramid\",\"C.K. Prahalad\",,\"Kindle\"\n" +
                    "\"Beezer\",\"Brandon T. Snider\",,\"Audible\"\n" +
                    "\"Caffeine\",\"Michael Pollan\",,\"Audible\"\n" +
                    "\"The Worry Trick\",\"David Carbonell\",,\"Audible\"\n" +
                    "\"The Phoenix Project\",\"Gene Kim\",,\"Audible\"\n" +
                    "\"Sober Curious\",\"Ruby Warrington\",,\"Audible\"\n" +
                    "\"Chemistry and Our Universe\",\"Ron B. Davis\",,\"Audible\"\n" +
                    "\"Invisible Women\",\"Caroline Criado Perez\",,\"Audible\"\n" +
                    "\"Will My Cat Eat My Eyeballs?\",\"Caitlin Doughty\",,\"Audible\"\n" +
                    "\"The Age of Living Machines\",\"Susan Hockfield\",,\"Audible\"\n" +
                    "\"Ten Drugs\",\"Thomas Hager\",,\"Audible\"\n" +
                    "\"Computational Thinking\",\"Peter J. Denning\",,\"Audible\"\n" +
                    "\"Bullshit Jobs\",\"David Graeber\",,\"Audible\"\n" +
                    "\"Once Upon an Algorithm\",\"Martin Erwig\",,\"Audible\"\n" +
                    "\"Cosmos\",\"Carl Sagan\",,\"Audible\"\n" +
                    "\"A Grown-Up Guide to Dinosaurs\",\"Ben Garrod\",,\"Audible\"\n" +
                    "\"Stan Lee's Alliances: A Trick of Light\",\"Stan Lee\",,\"Audible\"\n" +
                    "\"Gene Machine\",\"Venki Ramakrishnan\",,\"Audible\"\n" +
                    "\"Human Errors\",\"Nathan H. Lents\",,\"Audible\"\n" +
                    "\"The Omnivore's Dilemma\",\"Michael Pollan\",,\"Audible\"\n" +
                    "\"How to Be a Good Creature\",\"Sy Montgomery\",,\"Audible\"\n" +
                    "\"Plant Science: An Introduction to Botany\",\"Catherine Kleier\",,\"Audible\"\n" +
                    "\"The Stranger in the Woods\",\"Michael Finkel\",,\"Audible\"\n" +
                    "\"Ready Player One\",\"Ernest Cline\",,\"Audible\"\n" +
                    "\"A Grimm Warning\",\"hris Colfer\",,\"Audible\"\n" +
                    "\"Girls Who Code\",\"Reshma Saujani\",,\"Audible\"\n" +
                    "\"Montessori from the Start\",\"Paula Polk Lillard\",,\"Audible\"\n" +
                    "\"Born a Crime\",\"Trevor Noah\",,\"Audible\"\n" +
                    "\"Never Ending Story\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Philosopher's Stone\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Order of the Phoenix\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Chamber of Secrets\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Goblet of Fire\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Deathly Hallows\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Prisoner of Azkaban\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Half-Blood Prince\",\"J. K. Rowling\",,\"Paperback\"\n" +
                    "\"Harry Potter and the Philosopher's Stone\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Order of the Phoenix\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Chamber of Secrets\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Goblet of Fire\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Deathly Hallows\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Prisoner of Azkaban\",,,\"DVD\"\n" +
                    "\"Harry Potter and the Half-Blood Prince\",,,\"DVD\"\n" +
                    "\"Captain America: The First Avenger\",,,\"DVD\"\n" +
                    "\"The Avengers\",,,\"DVD\"\n" +
                    "\"Return of the Jedi\",,,\"DVD\"\n" +
                    "\"The Empire Strikes Back\",,,\"DVD\"\n" +
                    "\"A New Hope\",,,\"DVD\"\n" +
                    "\"The Phantom Menace\",,,\"DVD\"\n" +
                    "\"Attack of the Clones\",,,\"DVD\"\n" +
                    "\"Revenge of the Sith\",,,\"DVD\"\n");
            writeToNewFile.close();
        } catch (IOException e){
            System.out.println("Couldn't write to file.");
        }
    }
}








