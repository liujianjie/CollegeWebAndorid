USE [JLGOUWU]
GO
/****** 对象:  Table [dbo].[bottom]    脚本日期: 05/10/2016 09:28:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bottom](
	[bottom_id] [int] IDENTITY(1,1) NOT NULL,
	[bottom] [varchar](20) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[mold_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[bottom_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [JLGOUWU]
GO
ALTER TABLE [dbo].[bottom]  WITH CHECK ADD FOREIGN KEY([mold_id])
REFERENCES [dbo].[mold] ([mold_id])





USE [JLGOUWU]
GO
/****** 对象:  Table [dbo].[comment]    脚本日期: 05/10/2016 09:28:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[comment](
	[c_id] [int] IDENTITY(1,1) NOT NULL,
	[jruser_id] [int] NOT NULL,
	[g_id] [int] NOT NULL,
	[c_comment] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[c_time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [JLGOUWU]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK__comment__g_id__2A4B4B5E] FOREIGN KEY([g_id])
REFERENCES [dbo].[goods] ([g_id])
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FK__comment__jruser___29572725] FOREIGN KEY([jruser_id])
REFERENCES [dbo].[jruser] ([jruser_id])






USE [JLGOUWU]
GO
/****** 对象:  Table [dbo].[goods]    脚本日期: 05/10/2016 09:28:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[goods](
	[g_id] [int] IDENTITY(1,1) NOT NULL,
	[bottom_id] [int] NULL,
	[g_name] [varchar](500) COLLATE Chinese_PRC_CI_AS NULL,
	[g_dress] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[g_dec] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[g_img] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[g_price] [float] NULL,
	[g_scj] [float] NULL,
	[g_count] [int] NULL,
	[g_sale] [int] NULL,
	[g_statu] [int] NULL,
	[gwccount] [int] NULL,
	[g_descrip] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
 CONSTRAINT [PK__goods__014935CB] PRIMARY KEY CLUSTERED 
(
	[g_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [JLGOUWU]
GO
ALTER TABLE [dbo].[goods]  WITH CHECK ADD  CONSTRAINT [FK__goods__bottom_id__023D5A04] FOREIGN KEY([bottom_id])
REFERENCES [dbo].[bottom] ([bottom_id])







USE [JLGOUWU]
GO
/****** 对象:  Table [dbo].[jruser]    脚本日期: 05/10/2016 09:28:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[jruser](
	[jruser_id] [int] IDENTITY(1,1) NOT NULL,
	[uname] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[pwd] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[jr_img] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[jointime] [datetime] NULL,
	[birthday] [datetime] NULL,
	[moneys] [float] NULL,
	[phone] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
 CONSTRAINT [PK__jruser__15502E78] PRIMARY KEY CLUSTERED 
(
	[jruser_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF







USE [JLGOUWU]
GO
/****** 对象:  Table [dbo].[mold]    脚本日期: 05/10/2016 09:29:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[mold](
	[mold_id] [int] IDENTITY(1,1) NOT NULL,
	[mold] [varchar](20) COLLATE Chinese_PRC_CI_AS NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mold_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF








USE [JLGOUWU]
GO
/****** 对象:  Table [dbo].[orders]    脚本日期: 05/10/2016 09:29:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orders](
	[orders_id] [int] IDENTITY(10000,1) NOT NULL,
	[jruser_id] [int] NULL,
	[xfm] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[statu] [int] NULL,
	[gtime] [datetime] NULL,
	[g_id] [int] NULL,
	[gname] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[gdec] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[gprice] [float] NULL,
	[gwccount] [int] NULL,
	[total] [float] NULL,
	[gimg] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
 CONSTRAINT [PK__orders__173876EA] PRIMARY KEY CLUSTERED 
(
	[orders_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF