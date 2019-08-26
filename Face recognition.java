A. START PAGE
using System;
usingSystem.Collections.Generic;
usingSystem.ComponentModel;
usingSystem.Data;
usingSystem.Drawing;
usingSystem.Linq;
usingSystem.Text;
usingSystem.Windows.Forms;
using System.IO;
using System.Net;
namespaceEmotionBasedAudioPlayer
{
public partial class Home : Form
{
public Home()
{
InitializeComponent();
}

private void button1_Click(object sender, EventArgs e)
{
Start s = new Start(); s.Show(); }



B. HOME PAGE
using System;
usingSystem.Collections.Generic;
usingSystem.ComponentModel;
usingSystem.Data;
usingSystem.Drawing;
usingSystem.Linq;
usingSystem.Text;
usingSystem.Windows.Forms;
usingSystem.Data.SqlClient;
using System.IO;

namespaceEmotionBasedAudioPlayer
{
public partial class AdminHome : Form
{
SqlConnection con = new
SqlConnection(@"DataSource=.\SQLEXPRESS;AttachDbFilename=D:
\ME2017\CMS\EmotionBasedAudioPlayer\EmotionBasedAudioPlayer\musictb.mdf;Inte
grated Security=True;User Instance=True");
SqlCommandcmd;
publicAdminHome()
{
InitializeComponent();
}
private void tabPage2_Click(object sender, EventArgs e)


{
}
private void AdminHome_Load(object sender, EventArgs e)
{
//cmd = new SqlCommand("select Fname,Lname,Gender,Mobile,Email from regtb ",
con);
//SqlDataAdapter da = new SqlDataAdapter(cmd);
//DataTabledt = new DataTable();
//da.Fill(dt);
//dataGridView1.DataSource = dt;
//dataGridView1.Refresh();
}
stringiName;
private void button1_Click(object sender, EventArgs e)
{
OpenFileDialogopFile = new OpenFileDialog();
opFile.Title = "Select a song";
opFile.Filter = "mp3 files (*.mp3)|*.MP3|All files (*.*)|*.*";

stringappPath = Path.GetDirectoryName(Application.ExecutablePath) +
@"\songs\"; if (Directory.Exists(appPath) == false)
{
Directory.CreateDirectory(appPath);
}
if (opFile.ShowDialog() == DialogResult.OK)
{
iName = opFile.SafeFileName;

stringfilepath = opFile.FileName;


if (File.Exists(appPath + iName))
{
textBox1.Text = opFile.FileName;
// MessageBox.Show(iName);
}
else
{
File.Copy(filepath, appPath + iName);

textBox1.Text =
opFile.FileName;
//Message}Box.Show("file");

}
else
{
opFile.Dispose();
}}
private void button2_Click(object sender, EventArgs e)
{
cmd = new SqlCommand("insert into songtb values(@Cat,@Song,@lan)", con);
cmd.Parameters.AddWithValue("@Cat", comboBox1.Text);
cmd.Parameters.AddWithValue("@Song", iName);
cmd.Parameters.AddWithValue("@lan", comboBox2.Text);

con.Open();

cmd.ExecuteNon
Query();
con.Close();


MessageBox.Show("Record Saved!");
}
private void button3_Click(object sender, EventArgs e)
{
textBox1.Text = "";
}}}


C. LOGIN PAGE
using System;
usingSystem.Collections.Generic;
usingSystem.ComponentModel;
usingSystem.Data;
usingSystem.Drawing;
usingSystem.Linq;
usingSystem.Text;
usingSystem.Windows.Forms;
usingSystem.Data.SqlClient;
namespaceEmotionBasedAudioPlayer
{
public partial class Login : Form
{
SqlConnectioncon BnewSqlConnection(@"Data
Source=.\SQLEXPRESS;AttachDbFilename=D:\ME2017\CMS\EmotionBasedAudioPla
yer \EmotionBasedAudioPlayer\musictb.mdf;Integrated Security=True;User
Instance=True");
SqlCommandcmd;
public Login()


{
InitializeComponent(); }
private void linkLabel1_LinkClicked(object
sender, LinkLabelLinkClickedEventArgs e) {
UserReg u = new UserReg(); u.Show(); }
private void button1_Click(object sender,
EventArgs e)
{
if (textBox1.Text == "admin" & textBox2.Text
== "admin")
{
AdminHome a = new AdminHome(); a.Show(); }
else {
MessageBox.Show("Username or Password
Incorrect");
}}

