USE [ѧ������]
GO

/****** Object:  Table [dbo].[SC]    Script Date: 2018/6/12 18:39:26 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SC](
	[Sno] [int] NOT NULL,
	[Cno] [smallint] NOT NULL,
	[grade] [float] NOT NULL
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SC]  WITH CHECK ADD  CONSTRAINT [fk_SC_1] FOREIGN KEY([Sno])
REFERENCES [dbo].[S] ([Sno])
GO

ALTER TABLE [dbo].[SC] CHECK CONSTRAINT [fk_SC_1]
GO

ALTER TABLE [dbo].[SC]  WITH CHECK ADD  CONSTRAINT [fk_SC_2] FOREIGN KEY([Cno])
REFERENCES [dbo].[C] ([Cno])
GO

ALTER TABLE [dbo].[SC] CHECK CONSTRAINT [fk_SC_2]
GO

SELECT * FROM SC;
